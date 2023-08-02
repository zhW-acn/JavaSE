package Rewriting_data_structures;

public class myLinklist {
    private Node head;
    private int length;

    private static class Node {
        private Integer data;
        private Node next;

        public Node() {

        }

        public Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    //打印所有元素
    public void printList() {
        String resultPrint = "[";
        for (Node i = head; i != null; i = i.getNext()) {
            resultPrint += i.getData() + "->";
        }
        if (resultPrint.equals("[")) {
            System.out.println("[]");
            return;
        }
        resultPrint = resultPrint.substring(0, resultPrint.length() - 2);
        resultPrint += "]";
        System.out.println(resultPrint);
    }

    //增删改查
    //增
    public void add(int index, int data) {//下标索引从1开始
        if (index == 1) {
            Node add = new Node();
            add.setData(data);
            add.setNext(head);
            head = add;
        } else {
            int i = 1;
            Node add = new Node();
            add.setData(data);
            Node q = head;
            while (i != index - 1) {
                q = q.getNext();
            }//q现在指向的是要插入位置的上一个元素
            add.setNext(q.getNext());
            q.setNext(add);
        }
        length++;
        System.out.println("在" + index + "处插入" + data + "成功");
    }

    public void add_tail(int data) {//尾插
        //创建一个指向头的Node
        Node addNode = new Node(data, null);
        if (head == null) {
            head = addNode;
        } else {
            Node i = head;
            while (i.getNext() != null) {//i指向最后一个结点
                i = i.getNext();
            }
            i.setNext(addNode);
        }
        length++;
        System.out.println("插入成功，此时尾元素为：" + data);
    }

    public void add_head(int data) {//头插
        //创建一个指向头的Node
        Node addNode = new Node(data, head);
        //头指针重新指向
        head = addNode;
        length++;
        System.out.println("插入成功，此时头元素为：" + data);
    }

    //删
    public void delete(int index) {
        //找到要删除元素的上一个结点
        if (index == 1) {
            head = head.getNext();
        } else {
            Node p = head;
            for (int i = 0; i < index - 2; i++) {
                p = p.getNext();
            }
            p.setNext(p.getNext().getNext());
        }
        System.out.println("第" + index + "个元素删除成功");
    }

    //改
    public void modify(int index, int data) {
        Node p = head;
        //找到要修改元素的上一个结点
        for (int i = 0; i < index - 1; i++) {
            p = p.getNext();
        }
        p.setData(data);
        System.out.println("第" + index + "个元素改为" + data + "成功");
    }

    //查
    public Integer query(int index) {
        int i = 1;
        Node q = head;
        while (i != index) {
            q = q.getNext();
            i++;
        }
        return q.getData();
    }
}
