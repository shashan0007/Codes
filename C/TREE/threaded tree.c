#include<stdio.h>
#include<conio.h>
struct node
{
   int n;
   int l,r;
   struct node *left,*right;
};
typedef struct node NODE;

NODE* insert(NODE *root,int info)
{
      NODE *temp,*par,*ptr;
      ptr=root;
      while(ptr!=NULL)
      {
         par=ptr;
         if(info<ptr->n)
         {
           if(ptr->l==0)
             ptr=ptr->left;
           else
             break;
         }
         else
         {
           if(ptr->r==0)
             ptr=ptr->right;
           else
             break;
         }
      }
      temp=(NODE*)malloc(sizeof(NODE));
      temp->n=info;
      temp->l=1;
      temp->r=1;
      if(par==NULL)
      {
        temp->left=NULL;
        temp->right=NULL;
        return temp;
      }
      else if(info<par->n)
      {
        temp->left=par->left;
        temp->right=par;
        par->l=0;
        par->left=temp;
      }
      else
      {
        temp->left=par;
        temp->right=par->right;
        par->r=0;
        par->right=temp;
      }
      return root;
}

void inorder(NODE* root)
{
     NODE* ptr;
     if(root==NULL)
     {
       printf("tree is empty");
       return;
     }
     ptr=root;
     while(ptr->l==0)
     {
       ptr=ptr->left;
     }
     while(ptr!=NULL)
     {
       printf("%d\n",ptr->n);
       if(ptr->r==1)
         ptr=ptr->right;
       else
       {
         ptr=ptr->right;
         while(ptr->l==0)
           ptr=ptr->left;
       }
     }
}

void preorder(NODE* root)
{
     NODE* ptr;
     if(root==NULL)
     {
       printf("tree is empty");
       return;
     }
     ptr=root;
     while(ptr!=NULL)
     {
       printf("%d\n",ptr->n);
       if(ptr->l==0)
         ptr=ptr->left;
       else if(ptr->r==0)
         ptr=ptr->right;
       else
       {
         while(ptr!=NULL && ptr->r==1)
           ptr=ptr->right;
         if(ptr!=NULL)
           ptr=ptr->right;
       }
     }
}

int main()
{
     int ch,num;
     NODE* root=NULL;
     while(1)
     {
        printf("\n1:insertion\n2:inorder\n3:preorder\n4:exit\n");
        printf("enter your choice:");
        scanf("%d",&ch);
        switch(ch)
        {
           case 1:printf("\nenter the data:");
                  scanf("%d",&num);
                  root=insert(root,num);
                  break;
           case 2:printf("\nTree is:\n");
                  inorder(root);
                  break;
           case 3:printf("\nTree is:\n");
                  preorder(root);
                  break;
           case 4:exit(1);
           default:printf("plz!!! enter correct choice.....");
        }
        printf("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        printf("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
     }
}
