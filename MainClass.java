import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.protobuf.ByteString;
import io.grpc.Context.Storage;

public class MainClass {

	
	public static void main(String args[]) {
		
		Pic2Str instance = new Pic2Str();
		
		String x = Pic2Str.PictureToString("https://www.google.com/imgres?imgurl=https%3A%2F%2Fd17fnq9dkz9hgj.cloudfront.net%2Fbreed-uploads%2F2018%2F09%2Fdog-landing-hero-lg.jpg%3Fbust%3D1536935129%26width%3D1080&imgrefurl=https%3A%2F%2Fwww.petfinder.com%2Fdog-breeds%2F&docid=7j5L-QcDix4o2M&tbnid=jPIpNCa-zhVMbM%3A&vet=10ahUKEwipx_z79Y_nAhWWLc0KHZg4BM0QMwh6KAAwAA..i&w=1080&h=447&itg=1&bih=714&biw=1536&q=dog&ved=0ahUKEwipx_z79Y_nAhWWLc0KHZg4BM0QMwh6KAAwAA&iact=mrc&uact=8");
		
		
		Str2Mp3 x = new Str2Mp3();
		ByteString bStr = x.writeMp3(x);

		try (OutputStream out = new FileOutputStream("convertedText.mp3")){
			out.write(bStr.toByteArray());
			System.out.println("Converted Text to Speech written to \"convertedText.mp3\"");
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
