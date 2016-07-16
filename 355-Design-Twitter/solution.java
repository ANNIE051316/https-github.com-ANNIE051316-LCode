public class Twitter {
    Map<Integer, Set<Integer>> followrelation;
    Map<Integer, List<Tweet>> tweetrelation;
    int tweetcount;
    class Tweet{
        int id;
        int tweetId;
        Tweet(int id, int tweetId) {
            this.id = id;
            this.tweetId = tweetId;
        }
    }
    
    /** Initialize your data structure here. */
    public Twitter() {
        followrelation = new HashMap();
        tweetrelation = new HashMap();
        tweetcount = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!tweetrelation.containsKey(userId)) {
            tweetrelation.put(userId, new ArrayList<Tweet>());
        }
        tweetrelation.get(userId).add(new Tweet(++tweetcount, tweetId));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> minheap = new PriorityQueue<Tweet>(11, new Comparator<Tweet>(){
            @Override
            public int compare(Tweet t1, Tweet t2) {
                return t1.id - t2.id;
            }
            });
        List<Integer> res = new ArrayList();
        if(tweetrelation.containsKey(userId)) {
            constructFeedList(minheap, userId);
        }
        
        if(followrelation.containsKey(userId)) {
            for(int follower : followrelation.get(userId)) {
                constructFeedList(minheap, follower);
            }
        }
        
        while(!minheap.isEmpty()) {
            res.add(0, minheap.poll().tweetId);
        }
        return res;
        
    }
    
    private void constructFeedList(PriorityQueue<Tweet> minheap, int userId) {
            if(!tweetrelation.containsKey(userId)) {
                return;
            }
            int sz = tweetrelation.get(userId).size();
            
            for(int i = 0; i < Math.min(10, sz); i++) {
                Tweet candidate = tweetrelation.get(userId).get(sz - 1 - i);
                int heapsz = minheap.size(); 
                
                if(minheap.size() >= 10 && minheap.peek().id > candidate.id) {
                    break;
                }
                if(heapsz < 10) {
                    minheap.offer(candidate);
                }
                else  {
                    minheap.poll();
                    minheap.offer(candidate);
                }
            }
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) {
            return;
        }
        if(!followrelation.containsKey(followerId)) {
            followrelation.put(followerId, new HashSet<Integer>());
        }
        followrelation.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followrelation.containsKey(followerId)) {
            if(followrelation.get(followerId).contains(followeeId)) {
                followrelation.get(followerId).remove(followeeId);
            }
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