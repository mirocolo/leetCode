package question.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author 何鑫
 * @Date 2022/11/29 10:07
 */
public class Application6OnLfuCache {
    /**
     * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
     *
     * 实现 LFUCache 类：
     *
     * LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
     * int get(int key) - 如果键 key 存在于缓存中，则获取键的值，否则返回 -1 。
     * void put(int key, int value) - 如果键 key 已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量 capacity 时，则应该在插入新项之前，移除最不经常使用的项。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。
     * 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。
     *
     * 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
     *
     * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/lfu-cache
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class LFUCache {

        int minFreq,capacity;
        Map<Integer,Node> keyTable;
        Map<Integer,DoublyLinkedList> freqTable;


        public LFUCache(int capacity) {
            this.minFreq = 0 ;
            this.capacity = capacity;
            keyTable = new HashMap<>(capacity);
            freqTable = new HashMap<>();
        }

        public int get(int key) {
            if(capacity == 0){
                return -1;
            }
            Node node = keyTable.get(key);
            if(null == node){
                return -1;
            }
            nodeFreqIncr(node);
            return node.val;
        }

        private void nodeFreqIncr(Node currentNode) {
            int currentFreq = currentNode.freq;
            int nextFreq = currentFreq + 1;
            freqTable.get(currentFreq).remove(currentNode);
            if(freqTable.get(currentFreq).size==0){
                freqTable.remove(currentFreq);
                if(minFreq == currentFreq){
                    minFreq = nextFreq;
                }
            }
            DoublyLinkedList list = freqTable.getOrDefault(nextFreq, new DoublyLinkedList());
            list.addFirst(new Node(currentNode.key, currentNode.val, nextFreq));
            freqTable.put(nextFreq,list);
            keyTable.put(currentNode.key,freqTable.get(nextFreq).getHead());
        }

        public void put(int key, int value) {
            if(capacity == 0){
                return;
            }
            if(!keyTable.containsKey(key)){
                if(keyTable.size()>=capacity){
                    DoublyLinkedList doublyLinkedList = freqTable.get(minFreq);
                    Node node = doublyLinkedList.getTail();
                    keyTable.remove(node.key);
                    doublyLinkedList.remove(node);
                    if (doublyLinkedList.size == 0) {
                        freqTable.remove(minFreq);
                    }
                }
                DoublyLinkedList list = freqTable.getOrDefault(1, new DoublyLinkedList());
                list.addFirst(new Node(key, value, 1));
                freqTable.put(1, list);
                keyTable.put(key, freqTable.get(1).getHead());
                minFreq = 1;
            }else {
                // 与 get 操作基本一致，除了需要更新缓存的值
                Node node = keyTable.get(key);
                node.val = value;
                nodeFreqIncr(node);
            }
        }

        class Node{
            int key,val,freq;
            Node prev,next;

            public Node() {
                this(-1,-1,0);
            }

            public Node(int key, int val, int freq) {
                this.key = key;
                this.val = val;
                this.freq = freq;
            }
        }

        class DoublyLinkedList{
            Node dummyHead,dummyTail;
            int size;

            public DoublyLinkedList() {
                dummyHead = new Node();
                dummyTail = new Node();
                dummyHead.next = dummyTail;
                dummyTail.prev = dummyHead;
                size = 0;
            }

            public void addFirst(Node node){
                node.prev = dummyHead;
                node.next = dummyHead.next;
                dummyHead.next.prev = node;
                dummyHead.next = node;
                size ++ ;
            }

            public void remove(Node node){
                node.next.prev = node.prev;
                node.prev.next = node.next;
                size --;
            }

            public Node getHead(){
                return dummyHead.next;
            }

            public Node getTail(){
                return dummyTail.prev;
            }
        }
    }


}
