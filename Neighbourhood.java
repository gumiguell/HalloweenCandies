class Neighbourhood {
    static class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static Pair solve(String s, int pos) {
        if (s.charAt(pos) == '(') {
            pos++;
            Pair left = solve(s, pos);
            pos++;
            Pair right = solve(s, pos);
            pos++;
            return new Pair(left.first + right.first + 1, left.second + right.second);
        } else {
            int num = 0;
            while (pos < s.length() && Character.isDigit(s.charAt(pos))) {
                num = num * 10 + (s.charAt(pos) - '0');
                pos++;
            }
            return new Pair(0, num);
        }
    }
}