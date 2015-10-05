
public class _0134_Gas_Station {

/*	There are N gas stations along a circular route, where the amount of gas at 
 *  station i is gas[i].

	You have a car with an unlimited gas tank and it costs cost[i] of gas to 
	travel from station i to its next station (i+1). You begin the journey with 
	an empty tank at one of the gas stations.

	Return the starting gas station's index if you can travel around the circuit 
	once, otherwise return -1.

	Note:
	The solution is guaranteed to be unique.*/
	
	class Solution {
	public:
	    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
	        int ans = 0;
	        int nowGas = 0;
	        int totalGas = 0;
	        for (int i = 0; i < gas.size(); i++) {
	            nowGas += gas[i] - cost[i];
	            if (nowGas < 0) {
	                ans = i + 1;
	                totalGas += nowGas;
	                nowGas = 0;
	            }
	        }
	        return totalGas + nowGas < 0 ? -1 : ans;
	    }
	};
	
}
