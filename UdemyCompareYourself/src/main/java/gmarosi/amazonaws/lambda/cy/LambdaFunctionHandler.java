package gmarosi.amazonaws.lambda.cy;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.json.JSONObject;
import org.json.JSONException;


public class LambdaFunctionHandler implements RequestHandler<Object, String> {

    @Override
    public String handleRequest(Object input, Context context) {
        context.getLogger().log("Input: " + input);
        String tmp =input.toString();
        //context.getLogger().log("tmp: " + tmp);
        int age=0;
		try {
			JSONObject json = new JSONObject(tmp);
	        //context.getLogger().log("json: " + json.toString());
			age = json.getInt("age");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
        // TODO: implement your handler
        return age*2+"";
    }

}
