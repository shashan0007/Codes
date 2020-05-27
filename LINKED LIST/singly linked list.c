#include<stdio.h>
#include<conio.h>
struct node
{
  int n;
  struct node *next;
}*start=NULL;
typedef struct node NODE;

void trav(NODE *p)
{
   while(p!=NULL)
   {
     printf("%d\n",p->n);
     p=p->next;
   }
}

void  inbeg(int item)
{
   NODE* p;
   p=(NODE*)malloc(sizeof(NODE));
   p->next=start;
   start=p;
   p->n=item;
}

void inend(int item)
{
   NODE* p,*loc;
   loc=start;
   p=(NODE*)malloc(sizeof(NODE));
   p->n=item;
   p->next=NULL;
   if(start==NULL)
   {
     start=p;
   }
   else
   {
     while(loc->next!=NULL)
     { 
       loc=loc->next;
     }
     loc->next=p;
   }
}

void delbeg()
{
   NODE*p;
   if(start==NULL)
   {
      printf("list is empty\n");
   }
   else
   {
       p=start;
       start=start->next;
       printf("no. deleted is %d\n",p->n);
       free(p);
   }
}

void delend()
{
     NODE *p,*loc;
     p=start;
     if(start==NULL)
     {
        printf("list is empty\n");
     }
     else if(start->next==NULL)
     {
        printf("no. deleted is %d\n",start->n);
        start=NULL;
        free(p);
     }
     else
     {
         while(p->next!=NULL)
         {
            loc=p;
            p=p->next;
         }
         loc->next=NULL;
         printf("no. deleted is %d\n",p->n);
         free(p);
     }
}

void insert_sp(int item,int loc)
{
     NODE *p,*temp=start;
     int k;
     for(k=1;k<loc-1;k++)
     {
       temp=temp->next;
       if(temp->next==NULL)
       {
         printf("insertion at end should be used");
         return;
       }
     }
     p=(NODE*)malloc(sizeof(NODE));
     p->n=item;
     p->next=temp->next;
     temp->next=p;
}

void del_sp()
{
     NODE *p,*temp;
     int i,loc;
     if(start==NULL)
     {
       printf("list is empty");
     }
     else
     {
         printf("enter the position:");
         scanf("%d",&loc);
         p=start;
         for(i=1;i<loc;i++)
         {
            temp=p;
            p=p->next;
         }
         printf("no. deleted is %d",p->n);
         temp->next=p->next;
         free(p);
     }
}
     

int main()
{
     int ch,item,loc;
     while(1)
     {
         printf("\n1:insert at begin\n2:insert at end\n3:insertion at specific position\n4:traverse the list\n5:delete at begin\n6:delete at end\n7:delete at specific position\n8:exit");
         printf("\nenter your choice:");
         scanf("%d",&ch);
         switch(ch)
         {
            case 1:printf("enter the element:");
                   scanf("%d",&item);
                   inbeg(item);
                   break;
            case 2:printf("enter the element:");
                   scanf("%d",&item);
                   inend(item);
                   break;
            case 3:printf("enter the element:");
                   scanf("%d",&item);
                   printf("enter the position:");
                   scanf("%d",&loc);
                   insert_sp(item,loc);
                   break;
            case 4:printf("\nlist is:\n");
                   trav(start);
                   break;
            case 5:delbeg();
                   break;
            case 6:delend();
                   break;
            case 7:del_sp();
                   break;
            case 8:exit(1);
            default:printf("enter correct choice");
         }//end of switch
     }//end of while loop
getch();

}
