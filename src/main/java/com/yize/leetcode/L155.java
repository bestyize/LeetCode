package com.yize.leetcode;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L155 {

    class MinStack{
        class Node{
            int val;
            int min;
            Node next;

            public Node(int val, int min) {
                this.val = val;
                this.min = min;
            }
        }
        Node head;
        public void push(int x){
            if(head==null){
                head=new Node(x,x);
            }else {
                Node newNode=new Node(x,Math.min(x,head.min));
                newNode.next=head;
                head=newNode;
            }
        }

        public void pop(){
            if(head==null){
                return;
            }
            head=head.next;
        }

        public int top(){
            if(head!=null){
                return head.val;
            }
            return -1;
        }

        public int getMin(){
            if(head!=null){
                return head.min;
            }
            return -1;
        }
    }

//    class MinStack{
//        private Stack<Integer> stack;
//        private Stack<Integer> minStack;
//        public MinStack() {
//            stack=new Stack<>();
//            minStack=new Stack<>();
//        }
//
//        public void push(int x) {
//            stack.push(x);
//            if(minStack.isEmpty()==false){
//                if(x<=minStack.peek()){
//                    minStack.push(x);
//                }
//            }else {
//                minStack.push(x);
//            }
//        }
//
//        public void pop() {
//            if(stack.pop().equals(minStack.peek())){
//                minStack.pop();
//            }
//        }
//
//        public int top() {
//            return stack.peek();
//        }
//
//        public int getMin() {
//            return minStack.peek();
//        }
//    }

}
