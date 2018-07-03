package com.siml.shop;

public class tets {
	public static void main(String[] args) {

		int value = 0;
		int jong, jung,cho;
		
		String word = "홍길동";
		for( int i = 0 ; i < word.length() ; i++ ) {
		 value = word.subSequence( i, i+1 ).hashCode() - 0xAC00;
		 jong = value % 28;
		 jung = ( ( value - jong ) / 28 ) % 21;
		 cho = ( int )( ( ( value - jong ) / 28 ) / 21 );
		}
		
	}
}
