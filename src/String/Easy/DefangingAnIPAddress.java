package String.Easy;

import java.util.Arrays;

public class DefangingAnIPAddress {
    public static void main(String[] args) {
        DefangingAnIPAddress o = new DefangingAnIPAddress();
        System.out.println(
                Arrays.toString(
                        new String[]{
                                o.defangIPaddr("0.0.0.0"),
                                o.defangIPaddr("1.1.1.1"),
                                o.defangIPaddr("255.100.50.0")
                        }
                )
        );

        // [0[.]0[.]0[.]0, 1[.]1[.]1[.]1, 255[.]100[.]50[.]0]
    }

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}

// https://leetcode.com/problems/defanging-an-ip-address/
