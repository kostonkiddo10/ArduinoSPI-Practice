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
		pixy.initAuto(4);
	//	pixy.setAutoTransmitData(new byte[0], 0);
	//	pixy.startAutoRate(100.0);
		//Must be called before starting SPI transfer engine, but the RoboRio
	}


	public void pixyRead() {

		//pixy.read(true, buffer, 4);

	
		for (int i = 0; i<4; i++){
			System.out.println(i + " " + buffer.get(i));
		}
		pixy.readAutoReceivedData(buffer, 0, 100);
		
	}

	public void pixyWrite(){
		byte[] arr = {'b', 'c',  '\b'};
		int received = pixy.write(arr, 3);
		//returns the size of the buffer
		System.out.println(received);
	}


} 