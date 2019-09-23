#include <iostream>
#include <vector>
#include <math.h>
using namespace std;

int main(){
	int n = 1000000;
//	cout<<"nhap n: ";cin>>n;
	vector<bool>snt(n+1,true);
	snt[1]=false;
	for(int i=2;i<=n;i++)
		snt[i] = true;
	int i= 2 ;
	while (i<=trunc(sqrt(n))){
		while(snt[i]==0)
			i++;
		for(int j=2;j<=n/i;j++)
			snt[i*j] = false;
		i++;
	}
	for(i=2;i<=n;i++){
		if(snt[i]) cout<<i<<" ";
	}
	
	return 0;
}
