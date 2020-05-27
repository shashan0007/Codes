#include<stdio.h>
#include<conio.h>
struct node 
{
   int n;
   struct node *left,*right;
};
typedef struct node NODE;
 
//RECURSIVE INSERTION IN BINARY TREE
NODE* insert(NODE* root,int item)
{
      if(root==NULL)
      {
         NODE *temp;
         temp=(NODE*)malloc(sizeof(NODE));
         temp->n=item;
         temp->left=temp->right=NULL;
         return temp;
      }
      else
      {
       if(item<root->n)
       {
         root->left=insert(root->left,item);
       }
       else
       {
         root->right=insert(root->right,item);
       }
      }
      return root;
}

//PREORDER TRAVERSE OF TREE
void preorder(NODE*root)
{
     if(root!=NULL)
     {
       printf("%d\n",root->n);
       preorder(root->left);
       preorder(root->right);
     }
}

//INORDER TRAVERSE OF TREE
void inorder(NODE*root)
{
     if(root!=NULL)
     {
       inorder(root->left);
       printf("%d\n",root->n);
       inorder(root->right);
     }
}

//POSTORDER TRAVERSE OF TREE
void postorder(NODE*root)
{
     if(root!=NULL)
     {
       postorder(root->left);
       postorder(root->right);
       printf("%d\n",root->n);
     }
}

//RECURSIVELY SEARCHING IN BINARY TREE
NODE* search(int item,NODE *root)
{
     if(root==NULL)
     {
        return root;
     }
     if(item==root->n)
     {
        return root;
     }
     if(item<root->n)
      return search(item,root->left);
     else
      return search(item,root->right);
}

//FINDING MAXIMUM NODE IN TREE
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

//FINDING MINIMUM NODE IN TREE
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
       
//CALCULATING HEIGHT OF TREE       
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

//COUNTING TOTAL NO. OF NODE
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

//COUNTING NO. OF LEAF NODE
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

//DELETION OF NODE FROM BINARY TREE
NODE* del(NODE* root,int item)
{
    NODE *cur,*par,*suc,*psuc,*q;
    if(item==root->n)
    {
      if(root->right==NULL)
      {
         cur=root->left;
      }
      else if(root->left==NULL)
      {
         cur=root->right;
      }
      else
      {               
        cur=root->right;
        if(cur->left==NULL)
        {
         cur->left=root->left;
        }
        else
        {
          while(cur->left!=NULL)
          {
           par=cur;              
           cur=cur->left;
          }
          cur->left=root->left;
          cur->right=root->right;
          par->left=NULL;
        }
      }
    free(root);
    return cur;
    }
    cur=root;
    while(cur!=NULL&&item!=cur->n)
    {
      par=cur;
      cur=(item<cur->n)?cur->left:cur->right;
    }
    if(cur==NULL)
    {
      printf("item not found");
      return root;
    }
    if(cur->left==NULL)
       q=cur->right;
    else if(cur->right==NULL)
       q=cur->left;
    else
    {
       psuc=cur;
       suc=cur->right;
       while(suc->left!=NULL)
       {
         psuc=suc;
         suc=suc->left;
       }
       if(cur==psuc)
         suc->left=cur->left;
       else
       {
         suc->left=cur->left;
         psuc->left=suc->right;
         suc->right=cur->right;
       }
       q=suc;
    }
    if(par->left==cur)
     par->left=q;
    else
     par->right=q;
    free(cur);
    return(root);
}

//MAIN FUNCTION
main()
{
   int item,ch;
   NODE *root,*p;
   root=NULL;
   while(1)
   {
     printf("\n1:insertion\n2:preorder\n3:inorder\n4:postorder\n5:display max element\n6:display min element\n7:height of tree\n8:count the total nodes\n9:count the leaf nodes\n10:search the element\n11:deletion\n12:exit\n");
     printf("enter your choice:");
     scanf("%d",&ch);
     switch(ch)
     {
       case 1:printf("enter the data:");
              scanf("%d",&item);
              root=insert(root,item);
              break;
       case 2:if(root==NULL)
               printf("tree is empty\n");
              else
               printf("tree is:\n");
               preorder(root);
              break;
       case 3:if(root==NULL)
               printf("tree is empty\n");
              else
               printf("tree is:\n");
               inorder(root);
              break;
       case 4:if(root==NULL)
               printf("tree is empty\n");
              else
               printf("tree is:\n");
               postorder(root);
              break;
       case 5:p=max(root);
              if(p==NULL)
              {
                printf("tree is empty\n");
              }
              else
              {
                printf("max element is %d\n",p->n);
              }
              break;
       case 6:p=min(root);
              if(p==NULL)
              {
                printf("tree is empty\n");
              }
              else
              {
                printf("min element is %d\n",p->n);
              }
              break;
       case 7:printf("hieght of tree is %d\n",height(root));
              break;
       case 8:count_node(root);
              printf("total no. of nodes is %d\n",count);
              count=0;
              break;
       case 9:count_leaf(root);
              printf("total no. of nodes is %d\n",count);
              count=0;
              break;
       case 10:printf("enter the element u have 2 search:");
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
       case 11:if(root==NULL)
               {
                 printf("tree is empty\n");
               }
               else
               {
                 printf("enter the element you have to delete:");
                 scanf("%d",&item);
                 root=del(root,item);
               }
               break;
       case 12:exit(1);
       default:printf("enter correct choice!!!\n");
     }
   }
}
