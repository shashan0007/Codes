#include<stdio.h>
#include<conio.h>

void selsort(int a[],int n)
{
   int temp,min,i,j;
   for(i=0;i<n-1;i++)
   {
     min=i;
     for(j=i+1;j<n;j++)
     {
       if(a[min]>a[j])
        min=j;
     }
     if(i!=min)
     {
       temp=a[i];
       a[i]=a[min];
       a[min]=temp;
     }
   }
}

void main()
{
  int a[100],n,i;
  printf("no. of elements in array:");
  scanf("%d",&n);
  printf("enter the elements:\n");
  for(i=0;i<n;i++)
  {
    scanf("%d",&a[i]);
  }
  selsort(a,n);
  printf("sorted list is:\n\t");
  for(i=0;i<n;i++)
  {
    printf("%d\n\t",a[i]);
  }
getch();
}
