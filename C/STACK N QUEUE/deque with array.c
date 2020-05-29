#include<stdio.h>
#include<conio.h>
#define MAX 10;
int deque[5];
void enquebeg();
void enqueend();
void dequebeg();
void dequeend();
void display();
int front=-1,rear=-1;
main()
{
     int choice,info;
     while(1)
     {
        printf("\n1:insert from begin\n2:insert from end\n3:delete from front\n4:delete from end\n5:display\n6:exit\n");
        printf("enter your choice:");
        scanf("%d",&choice);
        switch(choice)
        {
            case 1:
                 enquebeg();
               break;
            case 2:
                 enqueend();
               break;
            case 3:
                 dequebeg();
               break;
            case 4:
                 dequeend();
               break;
            case 5:
                 display();
               break;
            case 6:
                 exit(0);
            default:
                 printf("u have entered wrong choice");
        }
     }
getch();
}

void enquebeg()
{
     int i,info;
     if(front==0 && rear==4)
     {
         printf("queue is full");
     }
     else
     {
       printf("enter the element at begin:");
       scanf("%d",&info);
       if(front==-1)
       {
           front=rear=0;
           deque[front]=info;
       }
       else if(front==0 && rear!=4)
       {
          for(i=rear;i>=front;i--)
          {
             deque[i+1]=deque[i];
          }
          deque[front]=info;
          rear=rear+1;
       }
       else if(front>0)
       {
         front=front-1;
         deque[front]=info;
       }
     }
}

void enqueend()
{
     int i,info;
     if(front==0 && rear==4)
     {
          printf("queue is full");
     }
     else
     {
         printf("enter the element at end:");
         scanf("%d",&info);
         if(front==-1)
         {
            front=rear=0;
            deque[front]=info;
         }
         else if(front!=0 && rear==4)
         {
            for(i=front;i<=rear;i++)
            {
              deque[i-1]=deque[i];
            }
            front=front-1;
            deque[rear]=info;
         }
         else if(rear<4)
         {  
             rear=rear+1;
             deque[rear]=info;
         }
     }
}

void dequebeg()
{
     int info;
     if(front==-1)
     {
        printf("queue is empty");
     }
     else
     {
        info=deque[front];
        front++;
        if(front>rear)
        {
          front=rear=-1;
        }
     printf("deleted element from front:%d",info);
     }
}

void dequeend()
{
     int info;
     if(front==-1)
     {
        printf("queue is empty");
     }
     else
     {
         info=deque[rear];
         rear--;
         if(rear<front)
         {
            front=rear=-1;
         }
     printf("deleted element from front:%d",info);
     }
}

void display()
{
     int i;
     if(front==-1)
     {
       printf("queue is empty");
     }
     else
     {
       printf("queue:\n");
       for(i=front;i<=rear;i++)
       {
         printf("%d\n",deque[i]);
       }
     }
}
       
            
          
          
                
