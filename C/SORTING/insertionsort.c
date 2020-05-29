#include<stdio.h>
#include<conio.h>

void insertsort(int a[],int n)
{
    int i,j,k;
    for(i=1;i<n;i++)
    {
      k=a[i];
      for(j=i-1;j>=0&&k<a[j];j--)
      {
         a[j+1]=a[j];
      }
      a[j+1]=k;
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
  insertsort(a,n);
  printf("sorted list is:\n\t");
  for(i=0;i<n;i++)
  {
    printf("%d\n\t",a[i]);
  }
getch();
}
