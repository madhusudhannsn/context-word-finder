package com.focus.word;

public class Response {
	private boolean error;
	private String focusWord;
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getFocusWord() {
		return focusWord;
	}
	public void setFocusWord(String focusWord) {
		this.focusWord = focusWord;
	}
}
