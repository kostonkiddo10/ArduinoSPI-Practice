package frc.robot;


import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SPI.Port;
import java.nio.ByteBuffer;

public class Pixy  {
	SPI pixy;
	Port port = Port.kOnboardCS0;
	ByteBuffer buffer = ByteBuffer.allocateDirect(4);
	//Requires a direct buffer, must use allocateDirect.
	//

	String print;

	public Pixy() {
		pixy = new SPI(port);
		pixy.setClockRate(9600);
	//	pixy.initAuto(4);
	//	pixy.setAutoTransmitData(new byte[0], 0);
	//	pixy.startAutoRate(100.0);
		//Must be called before starting SPI transfer engine, but the RoboRio
	}


	public void pixyRead() {
	//try {
		//Never entered?
		//System.out.println("About to read.");
		pixy.read(true, buffer, 4);
		//System.out.println(read);

	/*	String v = new String( buffer.array(), StandardCharsets.UTF_8 );
		System.out.println(v + "\nSomething printed.");
		*/
		for (int i = 0; i<4; i++){
			System.out.println(i + " " + buffer.get(i));
		}
		//pixy.readAutoReceivedData(buffer, 0, 100);
		//The method returns the amount of data not read, not sure what to do with this, though
		//0 makes it read all the data available
	//	return new String(buffer.array(), "UTF-8") + "hello";
//}
	/*catch(UnsupportedEncodingException e){
		System.out.println("Exception: " + e.getMessage());
	}
	*/
	}

	public void pixyWrite(){
		byte[] arr = {'b', 'c',  '\b'};
		int received = pixy.write(arr, 3);
		//returns the size of the buffer
		System.out.println(received);
	}


} 