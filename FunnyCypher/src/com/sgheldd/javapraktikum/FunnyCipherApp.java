package com.sgheldd.javapraktikum;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by Georg on 25.04.2015.
 * (c) all tights reserved
 */
public class FunnyCipherApp {



	public static void main(String[] args) throws Exception {
        if (args.length < 3 ) {
			System.out.println("Too few arguments!");
			System.exit(-1);
		}
        FunnyCipher cryptoEngine = new FunnyCipher();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(args[2])));
        String line;

		while((line = br.readLine()) != null) {
			if (args[0].equals("d")) {
				cryptoEngine.decode(Integer.parseInt(args[1]), line);
			} else if (args[0].equals("e")) {
				cryptoEngine.encode(Integer.parseInt(args[1]), line);
			} else if (args[0].equals("b")){
				int key = cryptoEngine.findKey(line);
				System.out.println(key);
                cryptoEngine.decode(key,line);
			}else {
				System.out.println("Wrong parameter!");
			}
		}
	}
}
