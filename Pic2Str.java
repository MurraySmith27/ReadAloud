import clarifai2.dto.model.*;
import clarifai2.dto.prediction.*;
import clarifai2.api.*;
import clarifai2.api.request.model.*;
import clarifai2.dto.input.*;
import clarifai2.dto.model.output.*;
import java.util.*;
		/**
		 *
		 * @author Eric Lin
		 */
public class Pic2Str {

	public String PictureToString(String path) {
				
		        // TODO code application logic here
		        final ClarifaiClient client = new ClarifaiBuilder("2878836a51a14c0589dd8766441d8412").buildSync();
		        Model<Concept> generalModel = client.getDefaultModels().generalModel();
		        PredictRequest<Concept> request = generalModel.predict().withInputs(
		                ClarifaiInput.forImage("https://samples.clarifai.com/metro-north.jpg")
		            );
		        List<ClarifaiOutput<Concept>> result = request.executeSync().get();
		        String returnStr;
		        for (ClarifaiOutput<Concept> res : result)
		                for (Concept datum : res.data())
		                    returnStr += datum.name() + ", ";
		        return returnStr
		        		
		       
		    }
		   
		} 
				
		
	}
	
	
}