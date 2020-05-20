package com.doubledumbao.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1,"宋江","及时雨");
        HeroNode node2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode node3 = new HeroNode(3,"吴用","小诸葛");
        HeroNode node4 = new HeroNode(4,"林冲","豹子头");
        HeroNode node5 = new HeroNode(5,"关圣","大刀");
        HeroNode node6 = new HeroNode(6,"公孙胜","真人");
        BinaryTree tree = new BinaryTree(node1);
        node1.setLeft(node2);
        node2.setLeft(node3);
        node2.setRight(node6);
        node1.setRight(node4);
        node4.setLeft(node5);
        tree.preOrder();
    }
}

class BinaryTree{

    private HeroNode root;

    public BinaryTree(HeroNode root) {
        this.root = root;
    }

    public void preOrder(){
        if(root!=null){
            System.out.println(root);
        }
        if(root.getLeft() != null){
            preOrder(root.getLeft());
        }
        if(root.getRight()!=null){
            preOrder(root.getRight());
        }
    }

    private void preOrder(HeroNode heroNode){
        if(heroNode!=null){
            System.out.println(heroNode);
        }
        if(heroNode.getLeft() != null){
            preOrder(heroNode.getLeft());
        }
        if(heroNode.getRight()!=null){
            preOrder(heroNode.getRight());
        }
    }

}

class HeroNode{
    private int no;
    private String name;
    private String nickname;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name, String nickname) {
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

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
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
