/**
 * @Author : ungpung0
 * @Date    : 23/02/02
 * @Feature : 구문 해석 전후 관계를 나타내는 클래스.
 **/

package interpreter;

import java.text.ParseException;

public class Context {
    private String[] tokens;
    private String lastToken;
    private int index;

    public Context(String text) {
        this.tokens = text.split("\\s+");
        this.index = 0;
        nextToken();
    }

    /**
     * 다음 토큰을 얻는 메서드.
     */
    public String nextToken() {
        if(index < tokens.length)
            lastToken = tokens[index++];
        else
            lastToken = null;
        return lastToken;
    }

    /**
     * 현재 토큰을 얻는 메서드.
     */
    public String currentToken() {
        return lastToken;
    }

    /**
     * 현재 토큰을 검사하고, 다음 토큰을 얻는 메서드.
     * @param token
     *          토큰
     */
    public void skipToken(String token) throws ParseException {
        if(currentToken() == null)
            throw new ParseException("Error: '" + token + "' is expected, but no more token is found.");
        else if(!token.equals(currentToken())) {
            throw new ParseException("Error: '" + token + "' is expected, but '" + currentToken() + "' is found.");
        }
        nextToken();
    }

    /**
     * 현재 토큰의 수치를 얻는 메서드.
     */
    public int currentNumber() throws ParseException {
        if(currentToken() == null)
            throw new ParseException("Error: No more token.");
        int number = 0;
        try {
            number = Integer.parseInt(currentToken());
        }catch (NumberFormatException e) {
            throw new ParseException("Error: " + e);
        }
        return number;
    }
}
