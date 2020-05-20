package com.doubledumbao.linkedlist;

/**
 * 测试单向链表
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode heroNode1 = new HeroNode(1,"宋江","及时雨");
        HeroNode heroNode2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode heroNode3 = new HeroNode(3,"吴用","智多星");
        HeroNode heroNode4 = new HeroNode(4,"林冲","豹子头");
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode4);
        singleLinkedList.list();
        System.out.println(singleLinkedList.getLength(singleLinkedList.getHead()));
        System.out.println(singleLinkedList.findLastIndexKNode(singleLinkedList.getHead(),5));
    }
}

/**
 * 单向链表
 */
class SingleLinkedList{
    private HeroNode head;

    public SingleLinkedList(){
        head = new HeroNode(0,"","");
    }

    /**
     * 添加节点
     * @param heroNode
     */
    public void add(HeroNode heroNode){
        //思路：遍历链表中的节点，找到链表尾部，将链表尾部指针指向新节点
        HeroNode temp = head;
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    /**
     * 遍历单向链表
     */
    public void list(){
        if(head.next ==null){
            System.out.println("链表为空！");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }

    /**
     *  获取单向链表中节点的个数
     * @param head
     * @return
     */
    public int getLength(HeroNode head){
        int length = 0;
        if(head == null || head.next == null){
            return length;
        }
        HeroNode cur = head.next;
        while(cur!=null){
            length++;
            cur = cur.next;
        }
        return length;
    }

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }

    /**
     * 返回单向链表倒数第K个节点
     * @param k
     * @return
     */
    public HeroNode findLastIndexKNode(HeroNode head,int k){
        if(head == null || head.next == null){
            return null;
        }

        int length = getLength(head);
        if(k < 0 || k > length){
            return null;
        }
        HeroNode curNode = head.next;
        for (int i = 0; i < length-k; i++) {
            curNode = curNode.next;
        }
        return curNode;
    }
}

/**
 * 英雄节点
 */
class HeroNode{
    private int no;
    private String name;
    private String nickname;
    public HeroNode next;

    public HeroNode(){

    }
    public HeroNode(int no,String name,String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
