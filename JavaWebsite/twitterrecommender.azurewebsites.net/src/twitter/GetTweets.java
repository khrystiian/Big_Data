package twitter;

import java.util.List;

import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class GetTweets {
	
	public static String getAllTweets(String user){
		
		String tUser= null;
		if(user.charAt(0)=='@'){
			tUser = user;
		}else{
			tUser = "@" + user;
		}
		
		ConfigurationBuilder cb = new ConfigurationBuilder();

	    cb.setDebugEnabled(true)
	      .setOAuthConsumerKey("qcNC6qskrxDBACl8sXwYYpf5u")
	      .setOAuthConsumerSecret("Tdho8AZXIMGcftiVR7BWrDai4MDl9ebaYir1PII3L9caFNu9DI")
	      .setOAuthAccessToken("1583551296-6U5HVGnD3J6dNrkfPYRvP8SNOP2AxaRyhjbL2tH")
	      .setOAuthAccessTokenSecret("BwHS78eb9ySLnCzpJpVpRimzkkRzpxLxfotcTJ01LEe6s");

	    TwitterFactory tf = new TwitterFactory(cb.build());
	    Twitter twitter = tf.getInstance();
	    Paging paging = new Paging(1,700);
	    List<Status> statuses = null;
	    String tweets_list = "";
		try {
			
			statuses = twitter.getUserTimeline(tUser, paging);
			for (Status status : statuses) {
				if(status.getRetweetedStatus() == null){
					String[] words = status.getText().split(" ");
					String tweet = "";
					for(String word: words){
						if(!word.contains("@")){
							tweet += word +" "; 
						}
					}tweets_list += tweet.trim() + " ";// + "\n";
				}
				
			}
			tweets_list = tweets_list.replaceAll("\\S+://\\S+", "").replaceAll("@", "").replaceAll("#", "");
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tweets_list;
	}
     
}