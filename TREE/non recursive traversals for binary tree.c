#include<stdio.h>
#include<conio.h>
#define MAX 50
struct node 
{
   int n;
   struct node *left,*right;
};
typedef struct node NODE;
 
NODE* insert(NODE* root,int item)
{
      NODE *temp,*cur,*prev;
      temp=(NODE*)malloc(sizeof(NODE));
      temp->n=item;
      temp->left=temp->right=NULL;
       if(root==NULL)
       {
         return temp;
       }
      prev=NULL;
      cur=root;
       while(cur!=NULL)
       {
         prev=cur;
         cur=(item<cur->n)?cur->left:cur->right;
       }
       if(item<prev->n)
       {
         prev->left=temp;
       }
       else
       {
         prev->right=temp;
       }
      return root;
}


NODE *stack[MAX];
int top=-1;

void push(NODE *p)
{
     if(top==MAX)
     {
       printf("stack overflow\n");
       return;
     }
     top=top+1;
     stack[top]=p;
}

NODE *pop()
{
     NODE *p;
     if(top==-1)
     {
        printf("stack underflow\n");
        exit(1);
     }
     p=stack[top];
     top=top-1;
     return p;
}

int sempty()
{
    if(top==-1)
      return 1;
    else
      return 0;
}

void preorder(NODE*root)
{
     NODE *p;
     if(root==NULL)
     {
       printf("tree is empty\n");
       return;
     }
     /*push(p);
     while(!sempty())
     {
        p=pop();
        printf("%d\n",p->n);
        if(p->right!=NULL)
          push(p->right);
        if(p->left!=NULL)
          push(p->left);
     }
     printf("\n");*/
     p=root;
     while(1)
     {
       while(p!=NULL)
       {
         printf("%d\n",p->n);
         push(p);
         p=p->left;
       }
       if(top!=-1)
       {
         p=pop();
         p=p->right;
       }
       else
        return;
     }
}

void inorder(NODE*root)
{
     NODE *p=root;
     if(p==NULL)
     {
       printf("tree is empty\n");
       return;
     }
     /*while(1)
     {
       while(p->left!=NULL)
       {
         push(p);
         p=p->left;
       }
       while(p->right==NULL)
       {
         printf("%d\n",p->n);
         if(sempty())
            return;
         p=pop();
       }
       printf("%d\n",p->n);
       p=p->right;
     }
     printf("\n");*/
     while(1)
     {
        while(p!=NULL)
        {
          push(p);
          p=p->left;
        }
        if(top!=-1)
        {
          p=pop();
          printf("%d\n",p->n);
          p=p->right;
        }
        else
          return;
     }
}

void postorder(NODE*root)
{
     NODE *q,*p=root;
     if(p==NULL)
     {
       printf("tree is empty");
       return;
     }
     q=root;
     while(1)
     {
       while(p->left!=NULL)
       {
         push(p);
         p=p->left;
       }
       while(p->right==NULL || p->right==q)
       {
         printf("%d\n",p->n);
         q=p;
         if(sempty())
           return;
         p=pop();
       }
       push(p);
       p=p->right;
     }
     printf("\n");
}

NODE *queue[MAX];
int front=-1,rear=-1;
 
void inqueue(NODE*root)
{
     if(rear==MAX-1)
     {
        printf("queue overflow\n");
        return;
     }
     if(front==-1)
        front=0;
     rear=rear+1;
     queue[rear]=root;
}

NODE* delqueue()
{
     NODE *p;
     if(front==-1 || front==rear+1)
     {
        printf("queue underflow\n");
        return;
     }
     p=queue[front];
     front=front+1;
     return p;
}

int qempty()
{
     if(front==-1 || front==rear+1)
        return 1;
     else 
        return 0;
}

void levelorder(NODE*root)
{
     NODE *p=root;
     if(p==NULL)
     {
        printf("tree is empty\n");
        return;
     }
     inqueue(p);
     while(!qempty())
     {
        p=delqueue();
        printf("%d\n",p->n);
        if(p->left!=NULL)
            inqueue(p->left);
        if(p->right!=NULL)
            inqueue(p->right);
     }
     printf("\n");
}

NODE* search(int item,NODE *root)
{
     while(root!=NULL && item!=root->n)
     {
        root=(item<root->n)?root->left:root->right;
     }
     return root;
}

NODE* max(NODE* root)
{
     NODE *cur;
     if(root==NULL)
     {
       return root;
     }
     cur=root;
     while(cur->right!=NULL)
     {
       cur=cur->right;
     }
     return cur;
}

NODE* min(NODE* root)
{
     NODE *cur;
     if(root==NULL)
     {
       return root;
     }
     cur=root;
     while(cur->left!=NULL)
     {
       cur=cur->left;
     }
     return cur;
}
       
int max1(int a,int b)
{
  return(a>b)?a:b;
}

int height(NODE *root)
{
   if(root==NULL)
     return 0;
   else
     return 1+max1(height(root->left),height(root->right));
}

int count=0;
void count_node(NODE* root)
{
    if(root!=NULL)
    {
      count_node(root->left);
      count++;
      count_node(root->right);
    }
}

void count_leaf(NODE *root)
{
     if(root!=NULL)
     {
        count_leaf(root->left);
        if(root->left==NULL && root->right==NULL)
          count++;
        count_leaf(root->right);
     }
}

main()
{
   int item,ch;
   NODE *root,*p;
   root=NULL;
   while(1)
   {
     printf("\n1:insertion\n2:preorder\n3:inorder\n4:postorder\n5:levelorder\n6:display max element\n7:display min element\n8:height of tree\n9:count the total nodes\n10:count the leaf nodes\n11:search element\n12:exit\n");
     printf("enter your choice:");
     scanf("%d",&ch);
     switch(ch)
     {
       case 1: printf("enter the data:");
               scanf("%d",&item);
               root=insert(root,item);
               break;
       case 2: if(root==NULL)
                printf("tree is empty\n");
               else
                printf("tree is:\n");
                preorder(root);
               break;
       case 3: if(root==NULL)
                printf("tree is empty\n");
               else
                printf("tree is:\n");
                inorder(root);
               break;
       case 4: if(root==NULL)
                printf("tree is empty\n");
               else
                printf("tree is:\n");
                postorder(root);
               break;
       case 5: if(root==NULL)
                printf("tree is empty\n");
               else
                printf("tree is:\n");
                levelorder(root);
               break;
       case 6: p=max(root);
               if(p==NULL)
               {
                 printf("tree is empty\n");
               }
               else
               {
                 printf("max element is %d\n",p->n);
               }
               break;
       case 7: p=min(root);
               if(p==NULL)
               {
                 printf("tree is empty\n");
               } 
               else
               {
                  printf("min element is %d\n",p->n);
               }
               break;
       case 8: printf("hieght of tree is %d\n",height(root));
               break;
       case 9: count_node(root);
               printf("total no. of nodes is %d\n",count);
               count=0;
               break;
       case 10:count_leaf(root);
               printf("total no. of nodes is %d\n",count);
               count=0;
               break;
       case 11:printf("enter the element u have 2 search:");
               scanf("%d",&item);
               p=search(item,root);
               if(p==NULL)
               {
                 printf("element not found ......\n");
               }
               else
               {
                 printf("element is present in tree ......\n");
               }
               break;
       case 12:exit(1);
       default:printf("enter correct choice!!!\n");
     }
   }
   /*printf("enter the number of element to insert:");
   scanf("%d",&no);
     for(i=1;i<=no;i++)
     {
       printf("enter the element:");
       scanf("%d",&item);
       root=insert(item,root);
     }*/
}
