#include<stdio.h>
#include<conio.h>

struct node 
{
  int n;
  struct node *left;
  struct node *right;
}*root=NULL;
typedef struct node NODE;

//INSERTION OF ELEMENTS IN TREE
NODE *insert(NODE *rooot,int item)
{
   NODE *temp,*cur,*prev;
   char dir[10];
   int i;
   temp=(NODE*)malloc(sizeof(NODE));
   temp->n=item;
   temp->left=temp->right=NULL;
   if(root==NULL)
     return temp;
   else
   {
     printf("give the direction of insertion:");
     scanf("%s",dir);
     prev=NULL;
     cur=root;
     for(i=0;i<strlen(dir)&&cur!=NULL;i++)
     {
       prev=cur;
       cur=(dir[i]=='l')?cur->left:cur->right;
     }
     if(cur!=NULL)
     {
       printf("insertion not possible");
       free(temp);
       return root;
     }
     else
     {
       if(dir[--i]=='l')
         prev->left=temp;
       else
         prev->right=temp;
       return root;
     }
   } 
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

//MAIN FUNCTION
void main()
{
   int c,item;
   while(1)
   {
     printf("1:insertion\n2:preorder\n3:inorder\n4:postorder\n5:exit\n");
     printf("enter your choice:");
     scanf("%d",&c);
     switch(c)
     {
       case 1:printf("enter the element:");
              scanf("%d",&item);
              root=insert(root,item);
            break;
       case 2:if("root==NULL")
                printf("tree is empty\n");
              else
                printf("tree is:\n");
                preorder(root);
              break;
       case 3:if("root==NULL")
                printf("tree is empty\n");
              else
                printf("tree is:\n");
                inorder(root);
              break;
       case 4:if("root==NULL")
                printf("tree is empty\n");
              else
                printf("tree is:\n");
                postorder(root);
              break;
       case 5:exit(1);
       default:printf("enter the correct choice...");
     }
   }
}  
