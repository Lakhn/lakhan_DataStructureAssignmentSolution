package assigment2;



public class ques2
{
   int val;
   ques2 left, right;
   

   ques2(int item)
   {
       val = item;
       left = right = null;
   }
}
class GFG
{
   public static ques2 node;
   static ques2 prevNode = null;
   static ques2 headNode = null;
 
   static void flattenBTToSkewed(ques2 root,
                                 int order)
   {
      
   
       if(root == null)
       {
           return;
       }
      
     
       if(order > 0)
       {
           flattenBTToSkewed(root.right, order);
       }
       else
       {
           flattenBTToSkewed(root.left, order);
       }
       ques2 rightNode = root.right;
       ques2 leftNode = root.left;
      
       if(headNode == null)
       {
           headNode = root;
           root.left = null;
           prevNode = root;
       }
       else
       {
           prevNode.right = root;
           root.left = null;
           prevNode = root;
       }
   
       if (order > 0)
       {
           flattenBTToSkewed(leftNode, order);
       }
       else
       {
           flattenBTToSkewed(rightNode, order);
       }
   }
  
   static void traverseRightSkewed(ques2 root)
   {
       if(root == null)
       {
           return;
       }
       System.out.print(root.val + " ");
       traverseRightSkewed(root.right);       
   }
  
   public static void main (String[] args)
   {
       GFG tree = new GFG();
       tree.node = new ques2(50);
       tree.node.left = new ques2(30);
       tree.node.right = new ques2(60);
       tree.node.left.left=new ques2(10);
       tree.node.right.left=new ques2(55);
       
       int order = 0;
       flattenBTToSkewed(node, order);
       traverseRightSkewed(headNode);
   }
}
