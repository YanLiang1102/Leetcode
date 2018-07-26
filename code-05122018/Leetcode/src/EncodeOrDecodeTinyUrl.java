//just use the index of the urls as the short link
public class Codec {

    // Encodes a URL to a shortened URL.
    //just using the index of the arraylist of the short url
    ArrayList<String> urls=new ArrayList<String>();
    public String encode(String longUrl) {
        urls.add(longUrl);
        return String.valueOf(urls.size()-1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index=Integer.valueOf(shortUrl);
        if(index>=urls.size())
        {
            return "";
        }
        return urls.get(index);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
