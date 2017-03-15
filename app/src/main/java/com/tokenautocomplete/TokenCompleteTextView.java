package com.tokenautocomplete;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Layout;
import android.text.NoCopySpan;
import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.QwertyKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputMethodManager;
import android.widget.Filter;
import android.widget.MultiAutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView.CommaTokenizer;
import android.widget.MultiAutoCompleteTextView.Tokenizer;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import me.zhanghai.android.materialprogressbar.C1804R;
import org.java_websocket.util.Base64;

public abstract class TokenCompleteTextView<T> extends MultiAutoCompleteTextView implements OnEditorActionListener {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static final String TAG = "TokenAutoComplete";
    private boolean allowCollapse;
    private boolean allowDuplicates;
    private TokenDeleteStyle deletionStyle;
    private boolean focusChanging;
    private List<TokenImageSpan> hiddenSpans;
    private boolean hintVisible;
    boolean inInvalidate;
    private boolean initialized;
    private Layout lastLayout;
    private TokenListener<T> listener;
    private ArrayList<T> objects;
    private boolean performBestGuess;
    private CharSequence prefix;
    private boolean savingState;
    private T selectedObject;
    private boolean shouldFocusNext;
    private TokenSpanWatcher spanWatcher;
    private char[] splitChar;
    private TokenTextWatcher textWatcher;
    private TokenClickStyle tokenClickStyle;
    private int tokenLimit;
    private Tokenizer tokenizer;

    /* renamed from: com.tokenautocomplete.TokenCompleteTextView.1 */
    class C12911 implements InputFilter {
        C12911() {
        }

        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            if (TokenCompleteTextView.this.tokenLimit != -1 && TokenCompleteTextView.this.objects.size() == TokenCompleteTextView.this.tokenLimit) {
                return BuildConfig.FLAVOR;
            }
            if (source.length() == 1 && TokenCompleteTextView.this.isSplitChar(source.charAt(0))) {
                TokenCompleteTextView.this.performCompletion();
                return BuildConfig.FLAVOR;
            } else if (dstart >= TokenCompleteTextView.this.prefix.length()) {
                return null;
            } else {
                if (dstart == 0 && dend == 0) {
                    return null;
                }
                if (dend <= TokenCompleteTextView.this.prefix.length()) {
                    return TokenCompleteTextView.this.prefix.subSequence(dstart, dend);
                }
                return TokenCompleteTextView.this.prefix.subSequence(dstart, TokenCompleteTextView.this.prefix.length());
            }
        }
    }

    /* renamed from: com.tokenautocomplete.TokenCompleteTextView.2 */
    class C12922 implements Runnable {
        final /* synthetic */ Editable val$text;

        C12922(Editable editable) {
            this.val$text = editable;
        }

        public void run() {
            TokenCompleteTextView.this.setSelection(this.val$text.length());
        }
    }

    /* renamed from: com.tokenautocomplete.TokenCompleteTextView.3 */
    class C12933 implements Runnable {
        final /* synthetic */ Object val$object;
        final /* synthetic */ CharSequence val$sourceText;

        C12933(Object obj, CharSequence charSequence) {
            this.val$object = obj;
            this.val$sourceText = charSequence;
        }

        public void run() {
            if (this.val$object != null) {
                if (!TokenCompleteTextView.this.allowDuplicates && TokenCompleteTextView.this.objects.contains(this.val$object)) {
                    return;
                }
                if (TokenCompleteTextView.this.tokenLimit == -1 || TokenCompleteTextView.this.objects.size() != TokenCompleteTextView.this.tokenLimit) {
                    TokenCompleteTextView.this.insertSpan(this.val$object, this.val$sourceText);
                    if (TokenCompleteTextView.this.getText() != null && TokenCompleteTextView.this.isFocused()) {
                        TokenCompleteTextView.this.setSelection(TokenCompleteTextView.this.getText().length());
                    }
                }
            }
        }
    }

    /* renamed from: com.tokenautocomplete.TokenCompleteTextView.4 */
    class C12944 implements Runnable {
        final /* synthetic */ Object val$object;

        C12944(Object obj) {
            this.val$object = obj;
        }

        public void run() {
            int i = 0;
            Editable text = TokenCompleteTextView.this.getText();
            if (text != null) {
                TokenImageSpan span;
                ArrayList<TokenImageSpan> toRemove = new ArrayList();
                for (TokenImageSpan span2 : TokenCompleteTextView.this.hiddenSpans) {
                    if (span2.getToken().equals(this.val$object)) {
                        toRemove.add(span2);
                    }
                }
                Iterator it = toRemove.iterator();
                while (it.hasNext()) {
                    span2 = (TokenImageSpan) it.next();
                    TokenCompleteTextView.this.hiddenSpans.remove(span2);
                    TokenCompleteTextView.this.spanWatcher.onSpanRemoved(text, span2, 0, 0);
                }
                TokenCompleteTextView.this.updateCountSpan();
                TokenImageSpan[] spans = (TokenImageSpan[]) text.getSpans(0, text.length(), TokenImageSpan.class);
                int length = spans.length;
                while (i < length) {
                    span2 = spans[i];
                    if (span2.getToken().equals(this.val$object)) {
                        TokenCompleteTextView.this.removeSpan(span2);
                    }
                    i++;
                }
            }
        }
    }

    /* renamed from: com.tokenautocomplete.TokenCompleteTextView.5 */
    class C12955 implements Runnable {
        C12955() {
        }

        public void run() {
            int i = 0;
            Editable text = TokenCompleteTextView.this.getText();
            if (text != null) {
                TokenImageSpan[] spans = (TokenImageSpan[]) text.getSpans(0, text.length(), TokenImageSpan.class);
                int length = spans.length;
                while (i < length) {
                    TokenImageSpan span = spans[i];
                    TokenCompleteTextView.this.removeSpan(span);
                    TokenCompleteTextView.this.spanWatcher.onSpanRemoved(text, span, text.getSpanStart(span), text.getSpanEnd(span));
                    i++;
                }
            }
        }
    }

    /* renamed from: com.tokenautocomplete.TokenCompleteTextView.6 */
    class C12966 implements Runnable {
        C12966() {
        }

        public void run() {
            TokenCompleteTextView.this.performCollapse(TokenCompleteTextView.this.isFocused());
        }
    }

    /* renamed from: com.tokenautocomplete.TokenCompleteTextView.7 */
    static /* synthetic */ class C12977 {
        static final /* synthetic */ int[] f75x5c2071dc;
        static final /* synthetic */ int[] f76x945c4053;

        static {
            f75x5c2071dc = new int[TokenClickStyle.values().length];
            try {
                f75x5c2071dc[TokenClickStyle.Select.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f75x5c2071dc[TokenClickStyle.SelectDeselect.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f75x5c2071dc[TokenClickStyle.Delete.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f75x5c2071dc[TokenClickStyle.None.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            f76x945c4053 = new int[TokenDeleteStyle.values().length];
            try {
                f76x945c4053[TokenDeleteStyle.Clear.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f76x945c4053[TokenDeleteStyle.PartialCompletion.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f76x945c4053[TokenDeleteStyle.ToString.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f76x945c4053[TokenDeleteStyle._Parent.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        boolean allowCollapse;
        boolean allowDuplicates;
        ArrayList<Serializable> baseObjects;
        boolean performBestGuess;
        CharSequence prefix;
        char[] splitChar;
        TokenClickStyle tokenClickStyle;
        TokenDeleteStyle tokenDeleteStyle;

        /* renamed from: com.tokenautocomplete.TokenCompleteTextView.SavedState.1 */
        static class C12981 implements Creator<SavedState> {
            C12981() {
            }

            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        }

        SavedState(Parcel in) {
            boolean z;
            boolean z2 = true;
            super(in);
            this.prefix = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            this.allowCollapse = in.readInt() != 0 ? true : TokenCompleteTextView.$assertionsDisabled;
            if (in.readInt() != 0) {
                z = true;
            } else {
                z = TokenCompleteTextView.$assertionsDisabled;
            }
            this.allowDuplicates = z;
            if (in.readInt() == 0) {
                z2 = TokenCompleteTextView.$assertionsDisabled;
            }
            this.performBestGuess = z2;
            this.tokenClickStyle = TokenClickStyle.values()[in.readInt()];
            this.tokenDeleteStyle = TokenDeleteStyle.values()[in.readInt()];
            this.baseObjects = (ArrayList) in.readSerializable();
            this.splitChar = in.createCharArray();
        }

        SavedState(Parcelable superState) {
            super(superState);
        }

        public void writeToParcel(@NonNull Parcel out, int flags) {
            int i;
            int i2 = 1;
            super.writeToParcel(out, flags);
            TextUtils.writeToParcel(this.prefix, out, 0);
            out.writeInt(this.allowCollapse ? 1 : 0);
            if (this.allowDuplicates) {
                i = 1;
            } else {
                i = 0;
            }
            out.writeInt(i);
            if (!this.performBestGuess) {
                i2 = 0;
            }
            out.writeInt(i2);
            out.writeInt(this.tokenClickStyle.ordinal());
            out.writeInt(this.tokenDeleteStyle.ordinal());
            out.writeSerializable(this.baseObjects);
            out.writeCharArray(this.splitChar);
        }

        public String toString() {
            return ("TokenCompleteTextView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " tokens=" + this.baseObjects) + "}";
        }

        static {
            CREATOR = new C12981();
        }
    }

    public enum TokenClickStyle {
        None(TokenCompleteTextView.$assertionsDisabled),
        Delete(TokenCompleteTextView.$assertionsDisabled),
        Select(true),
        SelectDeselect(true);
        
        private boolean mIsSelectable;

        private TokenClickStyle(boolean selectable) {
            this.mIsSelectable = TokenCompleteTextView.$assertionsDisabled;
            this.mIsSelectable = selectable;
        }

        public boolean isSelectable() {
            return this.mIsSelectable;
        }
    }

    public enum TokenDeleteStyle {
        _Parent,
        Clear,
        PartialCompletion,
        ToString
    }

    protected class TokenImageSpan extends ViewSpan implements NoCopySpan {
        private T token;

        public TokenImageSpan(View d, T token, int maxWidth) {
            super(d, maxWidth);
            this.token = token;
        }

        public T getToken() {
            return this.token;
        }

        public void onClick() {
            Editable text = TokenCompleteTextView.this.getText();
            if (text != null) {
                switch (C12977.f75x5c2071dc[TokenCompleteTextView.this.tokenClickStyle.ordinal()]) {
                    case Base64.ENCODE /*1*/:
                    case Base64.GZIP /*2*/:
                        if (!this.view.isSelected()) {
                            TokenCompleteTextView.this.clearSelections();
                            this.view.setSelected(true);
                            return;
                        } else if (TokenCompleteTextView.this.tokenClickStyle == TokenClickStyle.SelectDeselect || !TokenCompleteTextView.this.isTokenRemovable(this.token)) {
                            this.view.setSelected(TokenCompleteTextView.$assertionsDisabled);
                            TokenCompleteTextView.this.invalidate();
                            return;
                        }
                    case C1804R.styleable.View_paddingEnd /*3*/:
                        break;
                    default:
                        if (TokenCompleteTextView.this.getSelectionStart() != text.getSpanEnd(this) + 1) {
                            TokenCompleteTextView.this.setSelection(text.getSpanEnd(this) + 1);
                            return;
                        }
                        return;
                }
                if (TokenCompleteTextView.this.isTokenRemovable(this.token)) {
                    TokenCompleteTextView.this.removeSpan(this);
                }
            }
        }
    }

    private class TokenInputConnection extends InputConnectionWrapper {
        public TokenInputConnection(InputConnection target, boolean mutable) {
            super(target, mutable);
        }

        public boolean deleteSurroundingText(int beforeLength, int afterLength) {
            if (!TokenCompleteTextView.this.canDeleteSelection(beforeLength)) {
                return TokenCompleteTextView.$assertionsDisabled;
            }
            if (TokenCompleteTextView.this.getSelectionStart() > TokenCompleteTextView.this.prefix.length()) {
                return super.deleteSurroundingText(beforeLength, afterLength);
            }
            if (TokenCompleteTextView.this.deleteSelectedObject(TokenCompleteTextView.$assertionsDisabled) || super.deleteSurroundingText(0, afterLength)) {
                return true;
            }
            return TokenCompleteTextView.$assertionsDisabled;
        }
    }

    public interface TokenListener<T> {
        void onTokenAdded(T t);

        void onTokenRemoved(T t);
    }

    private class TokenSpanWatcher implements SpanWatcher {
        private TokenSpanWatcher() {
        }

        public void onSpanAdded(Spannable text, Object what, int start, int end) {
            if ((what instanceof TokenImageSpan) && !TokenCompleteTextView.this.savingState && !TokenCompleteTextView.this.focusChanging) {
                TokenImageSpan token = (TokenImageSpan) what;
                TokenCompleteTextView.this.objects.add(token.getToken());
                if (TokenCompleteTextView.this.listener != null) {
                    TokenCompleteTextView.this.listener.onTokenAdded(token.getToken());
                }
            }
        }

        public void onSpanRemoved(Spannable text, Object what, int start, int end) {
            if ((what instanceof TokenImageSpan) && !TokenCompleteTextView.this.savingState && !TokenCompleteTextView.this.focusChanging) {
                TokenImageSpan token = (TokenImageSpan) what;
                if (TokenCompleteTextView.this.objects.contains(token.getToken())) {
                    TokenCompleteTextView.this.objects.remove(token.getToken());
                }
                if (TokenCompleteTextView.this.listener != null) {
                    TokenCompleteTextView.this.listener.onTokenRemoved(token.getToken());
                }
            }
        }

        public void onSpanChanged(Spannable text, Object what, int ostart, int oend, int nstart, int nend) {
        }
    }

    private class TokenTextWatcher implements TextWatcher {
        ArrayList<TokenImageSpan> spansToRemove;

        private TokenTextWatcher() {
            this.spansToRemove = new ArrayList();
        }

        protected void removeToken(TokenImageSpan token, Editable text) {
            text.removeSpan(token);
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            if (count > 0 && TokenCompleteTextView.this.getText() != null) {
                Editable text = TokenCompleteTextView.this.getText();
                int end = start + count;
                if (text.charAt(start) == ' ') {
                    start--;
                }
                TokenImageSpan[] spans = (TokenImageSpan[]) text.getSpans(start, end, TokenImageSpan.class);
                ArrayList<TokenImageSpan> spansToRemove = new ArrayList();
                for (TokenImageSpan token : spans) {
                    if (text.getSpanStart(token) < end && start < text.getSpanEnd(token)) {
                        spansToRemove.add(token);
                    }
                }
                this.spansToRemove = spansToRemove;
            }
        }

        public void afterTextChanged(Editable text) {
            ArrayList<TokenImageSpan> spansCopy = new ArrayList(this.spansToRemove);
            this.spansToRemove.clear();
            Iterator it = spansCopy.iterator();
            while (it.hasNext()) {
                TokenImageSpan token = (TokenImageSpan) it.next();
                int spanStart = text.getSpanStart(token);
                int spanEnd = text.getSpanEnd(token);
                removeToken(token, text);
                spanEnd--;
                if (spanEnd >= 0 && TokenCompleteTextView.this.isSplitChar(text.charAt(spanEnd))) {
                    text.delete(spanEnd, spanEnd + 1);
                }
                if (spanStart >= 0 && TokenCompleteTextView.this.isSplitChar(text.charAt(spanStart))) {
                    text.delete(spanStart, spanStart + 1);
                }
            }
            TokenCompleteTextView.this.clearSelections();
            TokenCompleteTextView.this.updateHint();
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
    }

    protected abstract T defaultObject(String str);

    protected abstract View getViewForObject(T t);

    static {
        $assertionsDisabled = !TokenCompleteTextView.class.desiredAssertionStatus() ? true : $assertionsDisabled;
    }

    protected void addListeners() {
        Editable text = getText();
        if (text != null) {
            text.setSpan(this.spanWatcher, 0, text.length(), 18);
            addTextChangedListener(this.textWatcher);
        }
    }

    protected void removeListeners() {
        int i = 0;
        Editable text = getText();
        if (text != null) {
            TokenSpanWatcher[] spanWatchers = (TokenSpanWatcher[]) text.getSpans(0, text.length(), TokenSpanWatcher.class);
            int length = spanWatchers.length;
            while (i < length) {
                text.removeSpan(spanWatchers[i]);
                i++;
            }
            removeTextChangedListener(this.textWatcher);
        }
    }

    private void init() {
        if (!this.initialized) {
            setTokenizer(new CommaTokenizer());
            this.objects = new ArrayList();
            Editable text = getText();
            if ($assertionsDisabled || text != null) {
                this.spanWatcher = new TokenSpanWatcher();
                this.textWatcher = new TokenTextWatcher();
                this.hiddenSpans = new ArrayList();
                addListeners();
                setTextIsSelectable($assertionsDisabled);
                setLongClickable($assertionsDisabled);
                setInputType((getInputType() | AccessibilityNodeInfoCompat.ACTION_COLLAPSE) | NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
                setHorizontallyScrolling($assertionsDisabled);
                setOnEditorActionListener(this);
                setFilters(new InputFilter[]{new C12911()});
                setDeletionStyle(TokenDeleteStyle.Clear);
                this.initialized = true;
                return;
            }
            throw new AssertionError();
        }
    }

    public TokenCompleteTextView(Context context) {
        super(context);
        this.splitChar = new char[]{',', ';'};
        this.deletionStyle = TokenDeleteStyle._Parent;
        this.tokenClickStyle = TokenClickStyle.None;
        this.prefix = BuildConfig.FLAVOR;
        this.hintVisible = $assertionsDisabled;
        this.lastLayout = null;
        this.allowDuplicates = true;
        this.focusChanging = $assertionsDisabled;
        this.initialized = $assertionsDisabled;
        this.performBestGuess = true;
        this.savingState = $assertionsDisabled;
        this.shouldFocusNext = $assertionsDisabled;
        this.allowCollapse = true;
        this.tokenLimit = -1;
        this.inInvalidate = $assertionsDisabled;
        init();
    }

    public TokenCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.splitChar = new char[]{',', ';'};
        this.deletionStyle = TokenDeleteStyle._Parent;
        this.tokenClickStyle = TokenClickStyle.None;
        this.prefix = BuildConfig.FLAVOR;
        this.hintVisible = $assertionsDisabled;
        this.lastLayout = null;
        this.allowDuplicates = true;
        this.focusChanging = $assertionsDisabled;
        this.initialized = $assertionsDisabled;
        this.performBestGuess = true;
        this.savingState = $assertionsDisabled;
        this.shouldFocusNext = $assertionsDisabled;
        this.allowCollapse = true;
        this.tokenLimit = -1;
        this.inInvalidate = $assertionsDisabled;
        init();
    }

    public TokenCompleteTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.splitChar = new char[]{',', ';'};
        this.deletionStyle = TokenDeleteStyle._Parent;
        this.tokenClickStyle = TokenClickStyle.None;
        this.prefix = BuildConfig.FLAVOR;
        this.hintVisible = $assertionsDisabled;
        this.lastLayout = null;
        this.allowDuplicates = true;
        this.focusChanging = $assertionsDisabled;
        this.initialized = $assertionsDisabled;
        this.performBestGuess = true;
        this.savingState = $assertionsDisabled;
        this.shouldFocusNext = $assertionsDisabled;
        this.allowCollapse = true;
        this.tokenLimit = -1;
        this.inInvalidate = $assertionsDisabled;
        init();
    }

    protected void performFiltering(@NonNull CharSequence text, int start, int end, int keyCode) {
        if (start < this.prefix.length()) {
            start = this.prefix.length();
        }
        Filter filter = getFilter();
        if (filter == null) {
            return;
        }
        if (this.hintVisible) {
            filter.filter(BuildConfig.FLAVOR);
        } else {
            filter.filter(text.subSequence(start, end), this);
        }
    }

    public void setTokenizer(Tokenizer t) {
        super.setTokenizer(t);
        this.tokenizer = t;
    }

    public void setDeletionStyle(TokenDeleteStyle dStyle) {
        this.deletionStyle = dStyle;
    }

    public void setTokenClickStyle(TokenClickStyle cStyle) {
        this.tokenClickStyle = cStyle;
    }

    public void setTokenListener(TokenListener<T> l) {
        this.listener = l;
    }

    public boolean isTokenRemovable(T t) {
        return true;
    }

    public void setPrefix(CharSequence p) {
        this.prefix = BuildConfig.FLAVOR;
        Editable text = getText();
        if (text != null) {
            text.insert(0, p);
        }
        this.prefix = p;
        updateHint();
    }

    public List<T> getObjects() {
        return this.objects;
    }

    public void setSplitChar(char[] splitChar) {
        char[] fixed = splitChar;
        if (splitChar[0] == ' ') {
            fixed = new char[(splitChar.length + 1)];
            fixed[0] = '\u00a7';
            System.arraycopy(splitChar, 0, fixed, 1, splitChar.length);
        }
        this.splitChar = fixed;
        setTokenizer(new CharacterTokenizer(splitChar));
    }

    public void setSplitChar(char splitChar) {
        setSplitChar(new char[]{splitChar});
    }

    private boolean isSplitChar(char c) {
        for (char split : this.splitChar) {
            if (c == split) {
                return true;
            }
        }
        return $assertionsDisabled;
    }

    public void allowDuplicates(boolean allow) {
        this.allowDuplicates = allow;
    }

    public void performBestGuess(boolean guess) {
        this.performBestGuess = guess;
    }

    public void allowCollapse(boolean allowCollapse) {
        this.allowCollapse = allowCollapse;
    }

    public void setTokenLimit(int tokenLimit) {
        this.tokenLimit = tokenLimit;
    }

    public CharSequence getTextForAccessibility() {
        if (getObjects().size() == 0) {
            return getText();
        }
        CharSequence description = new SpannableStringBuilder();
        Editable text = getText();
        int selectionStart = -1;
        int selectionEnd = -1;
        int i = 0;
        while (i < text.length()) {
            if (i == Selection.getSelectionStart(text)) {
                selectionStart = description.length();
            }
            if (i == Selection.getSelectionEnd(text)) {
                selectionEnd = description.length();
            }
            TokenImageSpan[] tokens = (TokenImageSpan[]) text.getSpans(i, i, TokenImageSpan.class);
            if (tokens.length > 0) {
                TokenImageSpan token = tokens[0];
                description = description.append(this.tokenizer.terminateToken(token.getToken().toString()));
                i = text.getSpanEnd(token);
            } else {
                description = description.append(text.subSequence(i, i + 1));
            }
            i++;
        }
        if (i == Selection.getSelectionStart(text)) {
            selectionStart = description.length();
        }
        if (i == Selection.getSelectionEnd(text)) {
            selectionEnd = description.length();
        }
        if (selectionStart < 0 || selectionEnd < 0) {
            return description;
        }
        Selection.setSelection(description, selectionStart, selectionEnd);
        return description;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        if (event.getEventType() == Utility.DEFAULT_STREAM_BUFFER_SIZE) {
            CharSequence text = getTextForAccessibility();
            event.setFromIndex(Selection.getSelectionStart(text));
            event.setToIndex(Selection.getSelectionEnd(text));
            event.setItemCount(text.length());
        }
    }

    private int getCorrectedTokenEnd() {
        return this.tokenizer.findTokenEnd(getText(), getSelectionEnd());
    }

    private int getCorrectedTokenBeginning(int end) {
        int start = this.tokenizer.findTokenStart(getText(), end);
        if (start < this.prefix.length()) {
            return this.prefix.length();
        }
        return start;
    }

    protected String currentCompletionText() {
        if (this.hintVisible) {
            return BuildConfig.FLAVOR;
        }
        Editable editable = getText();
        int end = getCorrectedTokenEnd();
        return TextUtils.substring(editable, getCorrectedTokenBeginning(end), end);
    }

    protected float maxTextWidth() {
        return (float) ((getWidth() - getPaddingLeft()) - getPaddingRight());
    }

    @TargetApi(16)
    private void api16Invalidate() {
        if (this.initialized && !this.inInvalidate) {
            this.inInvalidate = true;
            setShadowLayer(getShadowRadius(), getShadowDx(), getShadowDy(), getShadowColor());
            this.inInvalidate = $assertionsDisabled;
        }
    }

    public void invalidate() {
        if (VERSION.SDK_INT >= 16) {
            api16Invalidate();
        }
        super.invalidate();
    }

    public boolean enoughToFilter() {
        boolean z = true;
        if (this.tokenizer == null || this.hintVisible || getSelectionEnd() < 0) {
            return $assertionsDisabled;
        }
        int end = getCorrectedTokenEnd();
        if (end - getCorrectedTokenBeginning(end) < Math.max(getThreshold(), 1)) {
            z = false;
        }
        return z;
    }

    public void performCompletion() {
        if ((getAdapter() == null || getListSelection() == -1) && enoughToFilter()) {
            Object bestGuess;
            if (getAdapter() == null || getAdapter().getCount() <= 0 || !this.performBestGuess) {
                bestGuess = defaultObject(currentCompletionText());
            } else {
                bestGuess = getAdapter().getItem(0);
            }
            replaceText(convertSelectionToString(bestGuess));
            return;
        }
        super.performCompletion();
    }

    public InputConnection onCreateInputConnection(@NonNull EditorInfo outAttrs) {
        InputConnection superConn = super.onCreateInputConnection(outAttrs);
        if (superConn == null) {
            return null;
        }
        TokenInputConnection conn = new TokenInputConnection(superConn, true);
        outAttrs.imeOptions &= -1073741825;
        outAttrs.imeOptions |= 268435456;
        return conn;
    }

    private void handleDone() {
        performCompletion();
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    }

    public boolean onKeyUp(int keyCode, @NonNull KeyEvent event) {
        boolean handled = super.onKeyUp(keyCode, event);
        if (this.shouldFocusNext) {
            this.shouldFocusNext = $assertionsDisabled;
            handleDone();
        }
        return handled;
    }

    public boolean onKeyDown(int keyCode, @NonNull KeyEvent event) {
        boolean handled = $assertionsDisabled;
        switch (keyCode) {
            case C1804R.styleable.Toolbar_collapseContentDescription /*23*/:
            case C1804R.styleable.AppCompatTheme_popupMenuStyle /*61*/:
            case C1804R.styleable.AppCompatTheme_textAppearanceSearchResultTitle /*66*/:
                if (event.hasNoModifiers()) {
                    this.shouldFocusNext = true;
                    handled = true;
                    break;
                }
                break;
            case C1804R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle /*67*/:
                handled = (!canDeleteSelection(1) || deleteSelectedObject($assertionsDisabled)) ? true : $assertionsDisabled;
                break;
        }
        if (handled || super.onKeyDown(keyCode, event)) {
            return true;
        }
        return $assertionsDisabled;
    }

    private boolean deleteSelectedObject(boolean handled) {
        int i = 0;
        if (this.tokenClickStyle != null && this.tokenClickStyle.isSelectable()) {
            Editable text = getText();
            if (text == null) {
                return handled;
            }
            TokenImageSpan[] spans = (TokenImageSpan[]) text.getSpans(0, text.length(), TokenImageSpan.class);
            int length = spans.length;
            while (i < length) {
                TokenImageSpan span = spans[i];
                if (span.view.isSelected()) {
                    removeSpan(span);
                    handled = true;
                    break;
                }
                i++;
            }
        }
        return handled;
    }

    public boolean onEditorAction(TextView view, int action, KeyEvent keyEvent) {
        if (action != 6) {
            return $assertionsDisabled;
        }
        handleDone();
        return true;
    }

    public boolean onTouchEvent(@NonNull MotionEvent event) {
        int action = event.getActionMasked();
        Editable text = getText();
        boolean handled = $assertionsDisabled;
        if (this.tokenClickStyle == TokenClickStyle.None) {
            handled = super.onTouchEvent(event);
        }
        if (isFocused() && text != null && this.lastLayout != null && action == 1) {
            int offset = getOffsetForPosition(event.getX(), event.getY());
            if (offset != -1) {
                TokenImageSpan[] links = (TokenImageSpan[]) text.getSpans(offset, offset, TokenImageSpan.class);
                if (links.length > 0) {
                    links[0].onClick();
                    handled = true;
                } else {
                    clearSelections();
                }
            }
        }
        if (handled || this.tokenClickStyle == TokenClickStyle.None) {
            return handled;
        }
        return super.onTouchEvent(event);
    }

    protected void onSelectionChanged(int selStart, int selEnd) {
        if (this.hintVisible) {
            selStart = 0;
        }
        selEnd = selStart;
        if (!(this.tokenClickStyle == null || !this.tokenClickStyle.isSelectable() || getText() == null)) {
            clearSelections();
        }
        if (this.prefix == null || (selStart >= this.prefix.length() && selEnd >= this.prefix.length())) {
            Editable text = getText();
            if (text != null) {
                TokenImageSpan[] spans = (TokenImageSpan[]) text.getSpans(selStart, selEnd, TokenImageSpan.class);
                int length = spans.length;
                int i = 0;
                while (i < length) {
                    TokenImageSpan span = spans[i];
                    int spanEnd = text.getSpanEnd(span);
                    if (selStart > spanEnd || text.getSpanStart(span) >= selStart) {
                        i++;
                    } else if (spanEnd == text.length()) {
                        setSelection(spanEnd);
                        return;
                    } else {
                        setSelection(spanEnd + 1);
                        return;
                    }
                }
            }
            super.onSelectionChanged(selStart, selEnd);
            return;
        }
        setSelection(this.prefix.length());
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.lastLayout = getLayout();
    }

    public void performCollapse(boolean hasFocus) {
        this.focusChanging = true;
        Editable text;
        if (hasFocus) {
            text = getText();
            if (text != null) {
                for (CountSpan count : (CountSpan[]) text.getSpans(0, text.length(), CountSpan.class)) {
                    text.delete(text.getSpanStart(count), text.getSpanEnd(count));
                    text.removeSpan(count);
                }
                for (TokenImageSpan span : this.hiddenSpans) {
                    insertSpan(span);
                }
                this.hiddenSpans.clear();
                if (this.hintVisible) {
                    setSelection(this.prefix.length());
                } else {
                    postDelayed(new C12922(text), 10);
                }
                if (((TokenSpanWatcher[]) getText().getSpans(0, getText().length(), TokenSpanWatcher.class)).length == 0) {
                    text.setSpan(this.spanWatcher, 0, text.length(), 18);
                }
            }
        } else {
            text = getText();
            if (!(text == null || this.lastLayout == null)) {
                int lastPosition = this.lastLayout.getLineVisibleEnd(0);
                TokenImageSpan[] tokens = (TokenImageSpan[]) text.getSpans(0, lastPosition, TokenImageSpan.class);
                int count2 = this.objects.size() - tokens.length;
                CountSpan[] countSpans = (CountSpan[]) text.getSpans(0, lastPosition, CountSpan.class);
                if (count2 > 0 && countSpans.length == 0) {
                    lastPosition++;
                    CountSpan cs = new CountSpan(count2, getContext(), getCurrentTextColor(), (int) getTextSize(), (int) maxTextWidth());
                    text.insert(lastPosition, cs.text);
                    if (Layout.getDesiredWidth(text, 0, cs.text.length() + lastPosition, this.lastLayout.getPaint()) > maxTextWidth()) {
                        text.delete(lastPosition, cs.text.length() + lastPosition);
                        if (tokens.length > 0) {
                            lastPosition = text.getSpanStart(tokens[tokens.length - 1]);
                            cs.setCount(count2 + 1);
                        } else {
                            lastPosition = this.prefix.length();
                        }
                        text.insert(lastPosition, cs.text);
                    }
                    text.setSpan(cs, lastPosition, cs.text.length() + lastPosition, 33);
                    this.hiddenSpans = new ArrayList(Arrays.asList((TokenImageSpan[]) text.getSpans(cs.text.length() + lastPosition, text.length(), TokenImageSpan.class)));
                    for (TokenImageSpan span2 : this.hiddenSpans) {
                        removeSpan(span2);
                    }
                }
            }
        }
        this.focusChanging = $assertionsDisabled;
    }

    public void onFocusChanged(boolean hasFocus, int direction, Rect previous) {
        super.onFocusChanged(hasFocus, direction, previous);
        if (!hasFocus) {
            performCompletion();
        }
        clearSelections();
        if (this.allowCollapse) {
            performCollapse(hasFocus);
        }
    }

    protected CharSequence convertSelectionToString(Object object) {
        this.selectedObject = object;
        switch (C12977.f76x945c4053[this.deletionStyle.ordinal()]) {
            case Base64.ENCODE /*1*/:
                return BuildConfig.FLAVOR;
            case Base64.GZIP /*2*/:
                return currentCompletionText();
            case C1804R.styleable.View_paddingEnd /*3*/:
                return object != null ? object.toString() : BuildConfig.FLAVOR;
            default:
                return super.convertSelectionToString(object);
        }
    }

    private SpannableStringBuilder buildSpannableForText(CharSequence text) {
        return new SpannableStringBuilder(String.valueOf(this.splitChar[0]) + this.tokenizer.terminateToken(text));
    }

    protected TokenImageSpan buildSpanForObject(T obj) {
        if (obj == null) {
            return null;
        }
        return new TokenImageSpan(getViewForObject(obj), obj, (int) maxTextWidth());
    }

    protected void replaceText(CharSequence text) {
        clearComposingText();
        if (this.selectedObject != null && !this.selectedObject.toString().equals(BuildConfig.FLAVOR)) {
            SpannableStringBuilder ssb = buildSpannableForText(text);
            TokenImageSpan tokenSpan = buildSpanForObject(this.selectedObject);
            Editable editable = getText();
            int cursorPosition = getSelectionEnd();
            int end = cursorPosition;
            int start = cursorPosition;
            if (!this.hintVisible) {
                end = getCorrectedTokenEnd();
                start = getCorrectedTokenBeginning(end);
            }
            String original = TextUtils.substring(editable, start, end);
            if (editable == null) {
                return;
            }
            if (tokenSpan == null) {
                editable.replace(start, end, BuildConfig.FLAVOR);
            } else if (this.allowDuplicates || !this.objects.contains(tokenSpan.getToken())) {
                QwertyKeyListener.markAsReplaced(editable, start, end, original);
                editable.replace(start, end, ssb);
                editable.setSpan(tokenSpan, start, (ssb.length() + start) - 1, 33);
            } else {
                editable.replace(start, end, BuildConfig.FLAVOR);
            }
        }
    }

    public boolean extractText(@NonNull ExtractedTextRequest request, @NonNull ExtractedText outText) {
        try {
            return super.extractText(request, outText);
        } catch (IndexOutOfBoundsException ignored) {
            Log.d(TAG, "extractText hit IndexOutOfBoundsException. This may be normal.", ignored);
            return $assertionsDisabled;
        }
    }

    public void addObject(T object, CharSequence sourceText) {
        post(new C12933(object, sourceText));
    }

    public void addObject(T object) {
        addObject(object, BuildConfig.FLAVOR);
    }

    public void removeObject(T object) {
        post(new C12944(object));
    }

    private void updateCountSpan() {
        int i = 0;
        Editable text = getText();
        CountSpan[] counts = (CountSpan[]) text.getSpans(0, text.length(), CountSpan.class);
        int newCount = this.hiddenSpans.size();
        int length = counts.length;
        while (i < length) {
            CountSpan count = counts[i];
            if (newCount == 0) {
                text.delete(text.getSpanStart(count), text.getSpanEnd(count));
                text.removeSpan(count);
            } else {
                count.setCount(this.hiddenSpans.size());
                text.setSpan(count, text.getSpanStart(count), text.getSpanEnd(count), 33);
            }
            i++;
        }
    }

    private void removeSpan(TokenImageSpan span) {
        Editable text = getText();
        if (text != null) {
            if (((TokenSpanWatcher[]) text.getSpans(0, text.length(), TokenSpanWatcher.class)).length == 0) {
                this.spanWatcher.onSpanRemoved(text, span, text.getSpanStart(span), text.getSpanEnd(span));
            }
            text.delete(text.getSpanStart(span), text.getSpanEnd(span) + 1);
            if (this.allowCollapse && !isFocused()) {
                updateCountSpan();
            }
        }
    }

    private void insertSpan(T object, CharSequence sourceText) {
        SpannableStringBuilder ssb = buildSpannableForText(sourceText);
        TokenImageSpan tokenSpan = buildSpanForObject(object);
        Editable editable = getText();
        if (editable != null) {
            if (!this.allowCollapse || isFocused() || this.hiddenSpans.isEmpty()) {
                int offset = editable.length();
                if (this.hintVisible) {
                    offset = this.prefix.length();
                    editable.insert(offset, ssb);
                } else {
                    String completionText = currentCompletionText();
                    if (completionText != null && completionText.length() > 0) {
                        offset = TextUtils.indexOf(editable, completionText);
                    }
                    editable.insert(offset, ssb);
                }
                editable.setSpan(tokenSpan, offset, (ssb.length() + offset) - 1, 33);
                if (!isFocused() && this.allowCollapse) {
                    performCollapse($assertionsDisabled);
                }
                if (!this.objects.contains(object)) {
                    this.spanWatcher.onSpanAdded(editable, tokenSpan, 0, 0);
                    return;
                }
                return;
            }
            this.hiddenSpans.add(tokenSpan);
            this.spanWatcher.onSpanAdded(editable, tokenSpan, 0, 0);
            updateCountSpan();
        }
    }

    private void insertSpan(T object) {
        String spanString = this.deletionStyle == TokenDeleteStyle.ToString ? object != null ? object.toString() : BuildConfig.FLAVOR : BuildConfig.FLAVOR;
        insertSpan(object, spanString);
    }

    private void insertSpan(TokenImageSpan span) {
        insertSpan(span.getToken());
    }

    public void clear() {
        post(new C12955());
    }

    private void updateHint() {
        Editable text = getText();
        CharSequence hintText = getHint();
        if (text != null && hintText != null && this.prefix.length() > 0) {
            HintSpan[] hints = (HintSpan[]) text.getSpans(0, text.length(), HintSpan.class);
            HintSpan hint = null;
            int testLength = this.prefix.length();
            if (hints.length > 0) {
                hint = hints[0];
                testLength += text.getSpanEnd(hint) - text.getSpanStart(hint);
            }
            if (text.length() == testLength) {
                this.hintVisible = true;
                if (hint == null) {
                    Typeface tf = getTypeface();
                    int style = 0;
                    if (tf != null) {
                        style = tf.getStyle();
                    }
                    ColorStateList colors = getHintTextColors();
                    HintSpan hintSpan = new HintSpan(null, style, (int) getTextSize(), colors, colors);
                    text.insert(this.prefix.length(), hintText);
                    text.setSpan(hintSpan, this.prefix.length(), this.prefix.length() + getHint().length(), 33);
                    setSelection(this.prefix.length());
                }
            } else if (hint != null) {
                int sStart = text.getSpanStart(hint);
                int sEnd = text.getSpanEnd(hint);
                text.removeSpan(hint);
                text.replace(sStart, sEnd, BuildConfig.FLAVOR);
                this.hintVisible = $assertionsDisabled;
            }
        }
    }

    private void clearSelections() {
        if (this.tokenClickStyle != null && this.tokenClickStyle.isSelectable()) {
            Editable text = getText();
            if (text != null) {
                for (TokenImageSpan token : (TokenImageSpan[]) text.getSpans(0, text.length(), TokenImageSpan.class)) {
                    token.view.setSelected($assertionsDisabled);
                }
                invalidate();
            }
        }
    }

    protected ArrayList<Serializable> getSerializableObjects() {
        ArrayList<Serializable> serializables = new ArrayList();
        for (Object obj : getObjects()) {
            if (obj instanceof Serializable) {
                serializables.add((Serializable) obj);
            } else {
                Log.e(TAG, "Unable to save '" + obj + "'");
            }
        }
        if (serializables.size() != this.objects.size()) {
            Log.e(TAG, "You should make your objects Serializable or override\ngetSerializableObjects and convertSerializableArrayToObjectArray");
        }
        return serializables;
    }

    protected ArrayList<T> convertSerializableArrayToObjectArray(ArrayList<Serializable> s) {
        return s;
    }

    public Parcelable onSaveInstanceState() {
        ArrayList<Serializable> baseObjects = getSerializableObjects();
        removeListeners();
        this.savingState = true;
        Parcelable superState = super.onSaveInstanceState();
        this.savingState = $assertionsDisabled;
        SavedState state = new SavedState(superState);
        state.prefix = this.prefix;
        state.allowCollapse = this.allowCollapse;
        state.allowDuplicates = this.allowDuplicates;
        state.performBestGuess = this.performBestGuess;
        state.tokenClickStyle = this.tokenClickStyle;
        state.tokenDeleteStyle = this.deletionStyle;
        state.baseObjects = baseObjects;
        state.splitChar = this.splitChar;
        addListeners();
        return state;
    }

    public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof SavedState) {
            SavedState ss = (SavedState) state;
            super.onRestoreInstanceState(ss.getSuperState());
            setText(ss.prefix);
            this.prefix = ss.prefix;
            updateHint();
            this.allowCollapse = ss.allowCollapse;
            this.allowDuplicates = ss.allowDuplicates;
            this.performBestGuess = ss.performBestGuess;
            this.tokenClickStyle = ss.tokenClickStyle;
            this.deletionStyle = ss.tokenDeleteStyle;
            this.splitChar = ss.splitChar;
            addListeners();
            Iterator it = convertSerializableArrayToObjectArray(ss.baseObjects).iterator();
            while (it.hasNext()) {
                addObject(it.next());
            }
            if (!isFocused() && this.allowCollapse) {
                post(new C12966());
                return;
            }
            return;
        }
        super.onRestoreInstanceState(state);
    }

    public boolean canDeleteSelection(int beforeLength) {
        if (this.objects.size() < 1) {
            return true;
        }
        int endSelection = getSelectionEnd();
        int startSelection = beforeLength == 1 ? getSelectionStart() : endSelection - beforeLength;
        Editable text = getText();
        for (TokenImageSpan span : (TokenImageSpan[]) text.getSpans(0, text.length(), TokenImageSpan.class)) {
            int startTokenSelection = text.getSpanStart(span);
            int endTokenSelection = text.getSpanEnd(span);
            if (!isTokenRemovable(span.token)) {
                if (startSelection == endSelection) {
                    if (endTokenSelection + 1 == endSelection) {
                        return $assertionsDisabled;
                    }
                } else if (startSelection <= startTokenSelection && endTokenSelection + 1 <= endSelection) {
                    return $assertionsDisabled;
                }
            }
        }
        return true;
    }
}
