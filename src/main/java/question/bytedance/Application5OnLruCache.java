package question.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author 何鑫
 * @Date 2022/11/25 14:56
 */
public class Application5OnLruCache {
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    /**
     * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
     * 实现 LRUCache 类：
     * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
     * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
     * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
     * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/lru-cache
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class LRUCache {

        private int capacity;

        Map<Integer,DoublyListNode> cache;

        DoublyListNode head;
        DoublyListNode tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>();
            head = new DoublyListNode();
            tail = new DoublyListNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DoublyListNode doublyListNode = cache.get(key);
            if(null == doublyListNode){
                return -1;
            }
            moveToHead(doublyListNode);
            return doublyListNode.value;
        }

        private void moveToHead(DoublyListNode doublyListNode) {
            removeNode(doublyListNode);
            addToHead(doublyListNode);
        }

        private void addToHead(DoublyListNode doublyListNode) {
            doublyListNode.prev = head;
            doublyListNode.next = head.next;
            head.next.prev = doublyListNode;
            head.next = doublyListNode;

        }

        private void removeNode(DoublyListNode doublyListNode) {
            doublyListNode.prev.next = doublyListNode.next;
            doublyListNode.next.prev = doublyListNode.prev;
        }

        public void put(int key, int value) {
            DoublyListNode doublyListNode = cache.get(key);
            if(null == doublyListNode){
                DoublyListNode newNode = new DoublyListNode(key,value);
                cache.put(key,newNode);
                addToHead(newNode);
                if(cache.size()>capacity){
                    DoublyListNode node = tail.prev;
                    removeNode(node);
                    cache.remove(node.key);
                }
            }else {
                doublyListNode.value = value;
                moveToHead(doublyListNode);

            }
        }

        class DoublyListNode{
            int key;
            int value;
            DoublyListNode prev;
            DoublyListNode next;

            public DoublyListNode() {
            }

            public DoublyListNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }


}
