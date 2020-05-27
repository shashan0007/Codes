#include<stdio.h>
#include<conio.h>
struct node
{
   int n;
   struct node* next;
   struct node* prev;
}*start=NULL,*last=NULL;
typedef struct node NODE;

void trav(NODE *p)
{
     while(p!=NULL)
     { 
       printf("%d\n",p->n);
       p=p->next;
     }
}

void inbeg()
{
     NODE* p;
     int item;
     p=(NODE*)malloc(sizeof(NODE));
     printf("enter the element:");
     scanf("%d",&item);
     p->n=item;
     if(start==NULL)
     {
        start=last=p;
        p->next=p->prev=NULL;
     }
     else
     {
        p->next=start;
        start->prev=p;
        p->prev=NULL;
        start=p;
     }
}

void inend()
{
     NODE* p;
     int item;
     p=(NODE*)malloc(sizeof(NODE));
     printf("enter the element:");
     scanf("%d",&item);
     p->n=item;
     if(start==NULL)
     {
        start=last=p;
        p->next=p->prev=NULL;
     }
     else
     {
        p->next=NULL;
        last->next=p;
        p->prev=last;
        last=p;
     }
}

void insp()
{
     NODE *p,*q,*temp;
     int pos,i;
     p=(NODE*)malloc(sizeof(NODE));
     printf("enter the element:");
     scanf("%d",&p->n);
     printf("enter the position:");
     scanf("%d",&pos);
      q=start;
     for(i=1;i<pos;i++)
     {
        temp=q;
        q=q->next;
     }
     temp->next=p;
     p->prev=temp;
     p->next=q;
     q->prev=p;
}

void delbeg()
{
     NODE* p;
     if(start==NULL)
     {
       printf("list is empty");
     }
     else if(start==last)
     {
       p=start;
       printf("no. deleted is %d\n",p->n);
       start=last=NULL;
       free(p);
     }
     else
     {
       p=start;
       printf("no.deleted is %d\n",p->n);
       start=start->next;
       start->prev=NULL;
       free(p);
     }
}

void delend()
{
     NODE* p;
     if(start==NULL)
     {
       printf("list is empty");
     }
     else if(start==last)
     {
       p=start;
       printf("no. deleted is %d\n",p->n);
       start=last=NULL;
       free(p);
     }
     else
     {
       p=last;
       printf("no.deleted is %d\n",p->n);
       last=last->prev;
       last->next=NULL;
       free(p);
     }
}       

void delsp()
{
     NODE *p,*q;
     int pos,i;
     printf("enter the position:");
     scanf("%d",&pos);
      p=start;
     for(i=1;i<pos;i++)
     {
       q=p;
       p=p->next;
     }
     q->next=p->next;
     p->next->prev=q;
     printf("no. deleted is %d",p->n);
     free(p);
}

int main()
{
     int ch,item;
     while(1)
     {
         printf("\n\n1:insert at begin\n2:insert at end\n3:insert at specific position\n4:traverse the list\n5:delete at begin\n6:delete at end\n7:delete at specific position\n8:exit");
         printf("\nenter your choice:");
         scanf("%d",&ch);
         switch(ch)
         {
            case 1:inbeg();
                   break;
            case 2:inend();
                   break;
            case 3:insp();
                   break;
            case 4:printf("\nlist is:\n");
                   trav(start);
                   break;
            case 5:delbeg();
                   break;
            case 6:delend();
                   break;
            case 7:delsp();
                   break;
            case 8:exit(1);
            default:printf("enter correct choice");
         }//end of switch
     }//end of while loop
getch();

}
