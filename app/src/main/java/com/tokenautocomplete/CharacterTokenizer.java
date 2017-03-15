package com.tokenautocomplete;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.MultiAutoCompleteTextView.Tokenizer;
import java.util.ArrayList;

public class CharacterTokenizer implements Tokenizer {
    ArrayList<Character> splitChar;

    CharacterTokenizer(char[] splitChar) {
        this.splitChar = new ArrayList(splitChar.length);
        for (char c : splitChar) {
            this.splitChar.add(Character.valueOf(c));
        }
    }

    public int findTokenStart(CharSequence text, int cursor) {
        int i = cursor;
        while (i > 0 && !this.splitChar.contains(Character.valueOf(text.charAt(i - 1)))) {
            i--;
        }
        while (i < cursor && text.charAt(i) == ' ') {
            i++;
        }
        return i;
    }

    public int findTokenEnd(CharSequence text, int cursor) {
        int len = text.length();
        for (int i = cursor; i < len; i++) {
            if (this.splitChar.contains(Character.valueOf(text.charAt(i)))) {
                return i;
            }
        }
        return len;
    }

    public CharSequence terminateToken(CharSequence text) {
        int i = text.length();
        while (i > 0 && text.charAt(i - 1) == ' ') {
            i--;
        }
        if (i > 0 && this.splitChar.contains(Character.valueOf(text.charAt(i - 1)))) {
            return text;
        }
        Object obj;
        StringBuilder stringBuilder = new StringBuilder();
        if (this.splitChar.size() <= 1 || ((Character) this.splitChar.get(0)).charValue() != ' ') {
            Character ch = (Character) this.splitChar.get(0);
        } else {
            obj = (Character) this.splitChar.get(1);
        }
        String token = stringBuilder.append(obj).append(" ").toString();
        if (!(text instanceof Spanned)) {
            return text + token;
        }
        CharSequence sp = new SpannableString(text + token);
        TextUtils.copySpansFrom((Spanned) text, 0, text.length(), Object.class, sp, 0);
        return sp;
    }
}
