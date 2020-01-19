import com.google.cloud.texttospeech.v1.*;
import com.google.protobuf.ByteString;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class Str2Mp3 {
	/*Creates a new instance of a class for converting strings mp3 files of narrated text from that string.*/
	
	public ByteString writeMp3(String textInput) {
		/*This function takes arguments
		 * textInput: the text to be narrated*/
		//Instantiate a client
		try (TextToSpeechClient client = TextToSpeechClient.create()){
			
			
			SynthesisInput input = SynthesisInput.newBuilder()
					.setText(textInput)
					.build();
			//set the text input to be synthesized
			VoiceSelectionParams voice = VoiceSelectionParams.newBuilder()
					.setLanguageCode("en-US")
					.setSsmlGender(SsmlVoiceGender.FEMALE)
					.build();
			//Set the type of audio file to write (MP3 in our case)
			AudioConfig audioConfig = AudioConfig.newBuilder()
					.setAudioEncoding(AudioEncoding.MP3)
					.build();
			//Perform the text-to-speech request on the text input wi the selected voice paramaters and audio file type
			SynthesizeSpeechResponse response = client.synthesizeSpeech(input, voice, audioConfig);
			
			//Get the audio contents from the response (as an object)
			ByteString audioContents = response.getAudioContent();
			
			return audioContents;
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
}