
public class _0065_Valid_Number {

/*	Validate if a given string is numeric.

	Some examples:
	"0" => true
	" 0.1 " => true
	"abc" => false
	"1 a" => false
	"2e10" => true
	Note: It is intended for the problem statement to be ambiguous. You should 
	gather all requirements up front before implementing one.

	Update (2015-02-10):
	The signature of the C++ function had been updated. If you still see your 
	function signature accepts a const char * argument, please click the reload 
	button  to reset your code definition.*/
	
	class Solution {
	public:
	    // idea: state translation
	    enum State {I, // integer                   ->{'+','-'}[0-9]+
	                D, // double                    ->Integer{'.'}[0-9]+
	                E, // number with exponential   ->{D,I}{'e','E'}Integer+
	                PI,// potential I               ->{'+','-'}
	                PD,// potential D               ->Integer{'.'}
	                PE,// potential E               ->{D,I}{'e','E'}{'+','-'}*
	                F  // Fail
	                };
	    bool isValid(char c){
	        if('0' <= c && c <= '9')
	            return true;
	        char token[] = {'e', 'E', '.', '+', '-'};
	        for(unsigned int i = 0; i < sizeof(token)/sizeof(char); ++i){
	            if (c == token[i])
	                return true;
	        }
	        return false;
	    }

	    bool isNumber(const char *s) {
	        if(s == NULL)
	            return false;
	        while(*s == ' ')
	            s++;
	        string str(s);
	        while(str[str.size() - 1] == ' ')
	            str.erase(str.size() - 1, 1);
	        if(str.length() == 0)
	            return false;
	        bool firstDigit = false;
	        for(unsigned int i = 0; i < str.length(); ++i){
	            char c = str[i];
	            if(!isValid(c))
	                return false;
	            if(!firstDigit && '0' <= c && c <= '9')
	                firstDigit = true;
	        }
	        if(!firstDigit)
	            return false;
	        // str.length > 0, all characters are isValided, at least one digit
	        State state;
	        firstDigit = false;
	        // initialize state
	        switch(str[0]){
	            case '+':
	            case '-':
	                state = PI;
	                break;
	            case '.':
	                state = PD;
	                break;
	            case 'e':
	            case 'E':
	                state = F;
	                break;
	            default: // [0-9]
	                state = I;
	                firstDigit = true;
	        }

	        for(unsigned int i = 1; i < str.length() && state != F; ++i){
	            char c = str[i];
	            if(c == '+' || c == '-'){
	                switch(state){
	                    case PE:
	                    {
	                        char prevChar = str[i-1];
	                        if(prevChar != '+' || prevChar != '-')
	                            state = PE;
	                        else
	                            state = F;
	                        break;
	                    }
	                    default:
	                        state = F;
	                }
	            }else if(c == 'e' || c == 'E'){
	                switch(state){
	                    case I:
	                    case D:
	                        state = PE;
	                        break;
	                    case PD:
	                        if(firstDigit)
	                            state = PE;
	                        else
	                            state = F;
	                        break;
	                    default:
	                        state = F;
	                }
	            }else if(c == '.'){
	                switch(state){
	                    case I:
	                    case PI:
	                        state = PD;
	                        break;
	                    default:
	                        state = F;
	                }
	            }else{ // c = [0-9]
	                firstDigit = true;
	                switch(state){
	                    case I:
	                    case PI:
	                        state = I;
	                        break;
	                    case D:
	                    case PD:
	                        state = D;
	                        break;
	                    case E:
	                    case PE:
	                        state = E;
	                }
	            }
	        }

	        return state == I || state == D || state == PD || state == E;
	    }
	};
	
}
