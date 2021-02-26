/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balancear;

import pilas.PilaA;

/**
 *
 * @author admin
 */
public class Balanceo {
    
      public static boolean balanceoParentesis(String cadena) {
        boolean respuesta = true;
        PilaA<Character> pila= new PilaA();
        int n = cadena.length();
        int i=0;
        char car;
        
        while(i<n && respuesta) {
            car = cadena.charAt(i);
            if(car=='(' || car=='{' || car=='[')
                pila.push(car);
            else 
                if(car==')' || car=='}' || car==']') {
                    if(pila.isEmpty()) //  "jhalsdf)"
                        respuesta = false;
                    else
                        switch(car) {
                            case ')':
                                if(pila.pop()!='(')
                                    respuesta = false;
                                break;
                            case '}':
                                if(pila.pop()!='{')
                                    respuesta = false;
                                break;
                            case ']':
                                if(pila.pop()!='[')
                                    respuesta = false;
                                break;
                        }
                }
            i++;
        }
        if(!pila.isEmpty())
            respuesta = false;
        
        return respuesta;
    }
      
}
