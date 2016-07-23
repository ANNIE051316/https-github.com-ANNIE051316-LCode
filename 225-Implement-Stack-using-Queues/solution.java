class MyStack {
    Queue<Integer> queue;
    // Push element x onto stack.
    public void push(int x) {
        if(queue == null) {
            queue = new LinkedList<Integer>();
        }
        Queue<Integer> tmpqueue = new LinkedList<Integer>();
        tmpqueue.offer(x);
        while(!queue.isEmpty()) {
            tmpqueue.offer(queue.poll());
        }
        
        queue = tmpqueue;
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}