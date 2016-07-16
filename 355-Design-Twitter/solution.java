public class Twitter {
    Map<Integer, User> users;
    int timestamp;
    
    class User{
        int userId;
        Set<User> followees;
        List<Tweet> tweets;
        User(int userId) {
            this.userId = userId;
            followees = new HashSet();
            tweets = new ArrayList<Tweet>();
        }
        
    }
    
    class Tweet{
        int time;
        int tweetId;
        Tweet(int tweetId) {
            this.time = timestamp++;
            this.tweetId = tweetId;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        users = new HashMap();
        timestamp = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!users.containsKey(userId)) {
            users.put(userId, new User(userId));
        }
        users.get(userId).tweets.add(new Tweet(tweetId));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<Integer>();
        if(!users.containsKey(userId)) {
            return res;
        }
        
        PriorityQueue<Tweet> minheap = new PriorityQueue<Tweet>(11, new Comparator<Tweet>() {
            @Override
            public int compare(Tweet t1, Tweet t2) {
                return t1.time - t2.time;
            }
        });
        
        constructFeedList(minheap, users.get(userId));
        for(User followee : users.get(userId).followees) {
            constructFeedList(minheap, followee);
        }
        
        while(!minheap.isEmpty()) {
            res.add(0, minheap.poll().tweetId);
        }
        return res;
    }
    
    private void constructFeedList(PriorityQueue<Tweet> heap, User user) {
        List<Tweet> candidates = user.tweets;
        int candisz = candidates.size();
        for(int i = 0; i < Math.min(10, candisz); i++) {
            Tweet candidate = candidates.get(candisz - i - 1);
            int heapsz = heap.size();
            if(heapsz == 10 && heap.peek().time > candidate.time) {
                break;
            }
            if(heapsz == 10) {
                heap.poll();
            }
            heap.offer(candidate);
        }
    }
    
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) {
            return;
        }
        if(!users.containsKey(followerId)) {
            users.put(followerId, new User(followerId));
        }
        if(!users.containsKey(followeeId)) {
            users.put(followeeId, new User(followeeId));
        }
        
        users.get(followerId).followees.add(users.get(followeeId));
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!users.containsKey(followeeId) || !users.containsKey(followerId)) {
            return;
        }
        
        if(users.get(followerId).followees.contains(users.get(followeeId))) {
            users.get(followerId).followees.remove(users.get(followeeId));
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */