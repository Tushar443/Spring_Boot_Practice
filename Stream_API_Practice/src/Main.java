import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] arg) {
//        NormalOpOnList();
        //PerformStreamOperationOnStudent();
        PerformStreamOperationOnEmployee();
//        UsedOfFlatMap();
//        PerformStreamOnString();
    }

    private static void UsedOfFlatMap() {
        int[][] arr = new int[][]{{1,2,3},{3,2,1}};
        OptionalInt max = IntStream.range(0, arr.length).flatMap(value -> IntStream.of(IntStream.of(arr[value]).sum())).max();
        System.out.println(max.getAsInt());

        System.out.println("Find max");
        int[] intArr = new int[]{2,3,5,1,3};
        System.out.println(Arrays.stream(intArr).max().getAsInt());
    }

    private static void PerformStreamOnString() {
        String url = "PF09/009/002/1";
        String[] urls = url.split("/");
        String claus = String.valueOf(Stream.of(urls).skip(2).findFirst());
        System.out.println(claus);
        StringBuilder sb = new StringBuilder();
        String string2 = Stream.of(urls).limit(4).map(s -> {
            String s1 = (s == urls[3]) ? "00" + urls[3] : s + "/";
            return s1;
        }).collect(Collectors.joining());

        String string = IntStream.range(0,urls.length)
                .mapToObj(i -> i == 3 ? "00"+urls[i] : urls[i]+"/").collect(Collectors.joining());

        System.out.println(string);
        String s = "is2 sentence4 This1 a3";
        String[] arr = s.split(" ");
        String collect = Stream.of(arr).sorted((s1, s2) -> {
            int k1 = s1.charAt(s1.length() - 1) + '0';
            int k2 = s2.charAt(s2.length() - 1) + '0';
            return k1 - k2;
        }).map(string1-> string1.substring(0,string1.length()-1)).collect(Collectors.joining(" "));
        System.out.println(collect);
    }

    private static void PerformStreamOperationOnEmployee() {
        ArrayList<Employee> list = new ArrayList<>(Arrays.asList(
                new Employee(1,"ABC", 1000.0),
                new Employee(2,"DEF", 5000.0),
                new Employee(3,"GHI", 2500.0),
                new Employee(4,"JKL", 3000.0),
                new Employee(5,"MNO", 3000.0),
                new Employee(6,"PQR", 2500.0),
                new Employee(7,"XYZ", 500.0),
                new Employee(8,"TMQ", 2500.0)
        ));

        //Find 3rd Largest Salary
        System.out.println("### Find 3rd Largest Salary");
        Map.Entry<Double, List<Employee>> doubleListEntry = list.stream()
                .collect(Collectors.groupingBy(Employee::getSalary))
                .entrySet().stream().sorted((x,z)-> (int) (z.getKey() - x.getKey()))
                .skip(2).findFirst().get();
        Map.Entry<Double, List<Employee>> doubleListEntry2 = list.stream()
                .collect(Collectors.groupingBy(Employee::getSalary))
                .entrySet().stream().sorted(Map.Entry.comparingByKey((o1, o2) -> (int) (o2-o1)))
                .skip(2).findFirst().get();
        System.out.println("1 = "+doubleListEntry.getKey() + " " +doubleListEntry.getValue());
        System.out.println("2 = "+doubleListEntry2.getKey() + " " +doubleListEntry2.getValue());
//      System.out.println(doubleListEntry);

        List<EmployeeTwo> empList = new ArrayList<>();
        empList.add(new EmployeeTwo(1, "abc", 28, 123, "F", "HR", "Blore", 2020));
        empList.add(new EmployeeTwo(2, "xyz", 29, 120, "F", "HR", "Hyderabad", 2015));
        empList.add(new EmployeeTwo(3, "efg", 30, 115, "M", "HR", "Chennai", 2014));
        empList.add(new EmployeeTwo(4, "def", 32, 125, "F", "HR", "Chennai", 2013));
        empList.add(new EmployeeTwo(5, "ijk", 22, 150, "F", "IT", "Noida", 2013));
        empList.add(new EmployeeTwo(6, "mno", 27, 140, "M", "IT", "Gurugram", 2017));
        empList.add(new EmployeeTwo(7, "uvw", 26, 130, "F", "IT", "Pune", 2016));
        empList.add(new EmployeeTwo(8, "pqr", 23, 145, "M", "IT", "Trivandrum", 2015));
        empList.add(new EmployeeTwo(9, "stv", 25, 160, "M", "IT", "Blore", 2010));


        System.out.println("### Grouping Employees by City");
        empList.stream().collect(Collectors.groupingBy(EmployeeTwo::getCity)).entrySet().forEach(System.out::println);

        System.out.println("### Grouping Employees by Age");
        empList.stream().collect(Collectors.groupingBy(EmployeeTwo::getAge)).entrySet().forEach(System.out::println);

        System.out.println("### Finding the Count of Male and Female Employees");
        empList.stream().collect(Collectors.groupingBy(EmployeeTwo::getGender,Collectors.counting()))
                .forEach((s, aLong) -> System.out.println("Gender = "+s +" count = "+aLong));

        System.out.println("### Department name names");
        empList.stream().map(EmployeeTwo::getDeptName).distinct().forEach(System.out::println);

        System.out.println("### Printing Employee Details by Age Criteria Age>28");
        empList.stream().filter(employeeTwo -> employeeTwo.getAge()>=28).forEach(System.out::println);

        System.out.println("### Finding Maximum Age of Employee");
        empList.stream().mapToInt(EmployeeTwo::getAge).max();
        Optional<Map.Entry<Integer, List<EmployeeTwo>>> max = empList.stream().collect(Collectors.groupingBy(EmployeeTwo::getAge)).entrySet().stream().max(Map.Entry.comparingByKey());
        System.out.println(max);

        System.out.println("### Printing Average Age of Male and Female Employees");
        empList.stream().collect(Collectors.groupingBy(EmployeeTwo::getGender,Collectors.averagingInt(EmployeeTwo::getAge))).entrySet().forEach(System.out::println);

        System.out.println("### Printing the Number of Employees in Each Department");
        empList.stream().collect(Collectors.groupingBy(EmployeeTwo::getDeptName,Collectors.counting())).entrySet().forEach(System.out::println);

        System.out.println("### Finding the Oldest Employee");
        Optional<Map.Entry<Integer, List<EmployeeTwo>>> min = empList.stream().collect(Collectors.groupingBy(EmployeeTwo::getYearOfJoining))
                .entrySet().stream().min(Map.Entry.comparingByKey());
        System.out.println(min);

        System.out.println("### Finding the Youngest Female Employee");
        Optional<Map.Entry<Integer, List<EmployeeTwo>>> max1 = empList.stream()
                .filter(employeeTwo -> employeeTwo.getGender().equalsIgnoreCase("F"))
                .collect(Collectors.groupingBy(EmployeeTwo::getYearOfJoining))
//                employeeTwo -> employeeTwo.getGender().equalsIgnoreCase("F")))
                .entrySet().stream().max(Map.Entry.comparingByKey());
        System.out.println(max1);

        System.out.println("### Finding Employees by Age Range 30 > Age > 30 ");
        empList.stream().collect(Collectors.partitioningBy(o -> o.getAge() > 30)).entrySet().forEach(System.out::println);

        System.out.println("### Finding Department with Highest Number of Employees");
        Map.Entry<String, Long> stringLongEntry = empList.stream().collect(Collectors.groupingBy(EmployeeTwo::getDeptName, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println(stringLongEntry);

        System.out.println("### Finding Employees from HR Department");
        empList.stream().filter(e->e.getDeptName().equalsIgnoreCase("HR")).forEach(System.out::println);
        System.out.println("### Finding Departments with Over 3 Employees");
        empList.stream().collect(Collectors.groupingBy(EmployeeTwo::getDeptName,Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue()>4).forEach(System.out::println);

        System.out.println("### Finding and Sorting Employees by City");
        empList.stream().sorted(Comparator.comparing(EmployeeTwo::getCity).reversed()
        ).forEach(System.out::println);

        System.out.println("### Sorting Employees by Name and Age");
        empList.stream().sorted(Comparator.comparing(EmployeeTwo::getName).thenComparing(EmployeeTwo::getAge).reversed())
                .forEach(System.out::println);

        System.out.println("### Finding the Highest Experienced Employee");
        Map.Entry<Integer, List<EmployeeTwo>> integerListEntry = empList.stream().collect(Collectors.groupingBy(EmployeeTwo::getYearOfJoining))
                .entrySet().stream().min(Map.Entry.comparingByKey()).get();


        System.out.println(integerListEntry);

        System.out.println("### Printing Average and Total Salary of the Organization");
        DoubleSummaryStatistics collect = empList.stream()
                .collect(Collectors.summarizingDouble(EmployeeTwo::getSalary));
        System.out.println("sum = "+ collect.getSum() +" average= "+ collect.getAverage());

        System.out.println("### Printing Average Salary of Each Department");
        empList.stream()
                .collect(Collectors.groupingBy(EmployeeTwo::getDeptName,Collectors.averagingDouble(EmployeeTwo::getSalary)))
                .entrySet().forEach(System.out::println);


        System.out.println("### Finding the Highest Paid Salary in the Organization Based on Gender");
        empList.stream().collect(Collectors.groupingBy(EmployeeTwo::getGender,Collectors.maxBy(Comparator.comparing(EmployeeTwo::getSalary))))
                .forEach((s, employeeTwo) -> System.out.println(s+" "+employeeTwo));

        System.out.println("### Printing the List of Employee's Second Highest salary Record Based on Department:");
        Map<String, Optional<EmployeeTwo>> collect1 = empList.stream()
                .collect(Collectors.groupingBy(EmployeeTwo::getDeptName,
                                                Collectors.collectingAndThen(Collectors.toList(), employeeTwos ->
                        employeeTwos.stream().sorted(Comparator.comparing(EmployeeTwo::getSalary).reversed()).skip(1).findFirst()
                )));

        System.out.println(collect1);

        System.out.println("### Sorting the Employees' Salary in Each Department in Ascending Order");
        Map<String, Stream<EmployeeTwo>> collect2 = empList.stream()
                .collect(Collectors.groupingBy(EmployeeTwo::getDeptName
                        , Collectors.collectingAndThen(Collectors.toList(),
                                employeeTwos -> employeeTwos.stream().sorted(Comparator.comparingDouble(EmployeeTwo::getSalary)))));

        collect2.forEach((s, employeeTwoStream) -> {
            System.out.println("Department = "+s);
            System.out.println(employeeTwoStream.collect(Collectors.toList()));
        });

        System.out.println("### Highest Salary by Department ###");
        Map<String, Long> collect3 = empList.stream().collect(Collectors.groupingBy(EmployeeTwo::getDeptName, Collectors.collectingAndThen(Collectors.toList(),
                employeeTwos -> employeeTwos.stream().max(Comparator.comparing(EmployeeTwo::getSalary)).get().getSalary()
        )));

        System.out.println(collect3);

        System.out.println("### sort map ###");
        empList.stream().collect(Collectors.groupingBy(EmployeeTwo::getYearOfJoining,Collectors.counting()))//.entrySet().forEach(System.out::println);
                .entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

        /**
         *  Sort the HashMap on key in reversed
         * HashMap<String,Integer> map = new HashMap<>();
         *         for(int i = 0;i<names.length;i++){
         *             map.put(names[i],heights[i]);
         *         }
         *         List<Map.Entry<String,Integer>> sorted = map.entrySet().stream()
         *         .sorted(Map.Entry.comparingByValue((o1,o2)-> o2-o1)).toList();
         *         sorted.forEach(System.out::println);
         *         String[] st = new String[names.length];
         *         int i = 0;
         *         for(Map.Entry<String,Integer> s : sorted){
         *             st[i++] = s.getKey();
         *         }
         *         return st;
         */
    }

    private static void NormalOpOnList() {
        List<Integer> list1 = List.of(10, 3, 6, 20, 30, 12, 1);

        Integer max = list1.stream().max(Integer::compareTo).get();
        Integer min = list1.stream().min((i, j) -> i.compareTo(j)).get();
        System.out.println("max= " + max + " min = " + min);

        List<Integer> sortedList = list1.stream().sorted().toList();
        System.out.println(sortedList);

        List<Integer> filterList = list1.stream().sorted().filter(i -> i > 5).collect(Collectors.toList());
        System.out.println(filterList);

        //sum of even numbers
        int sum = list1.stream().filter(i -> i % 2 == 0).mapToInt(Integer::intValue).sum();
        System.out.println("Sum = " + sum);
    }

    private static void PerformStreamOperationOnStudent() {
        List<Student> list = Arrays.asList(new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122), new Student(30, "Shubham", "Singh", 30, "Male", "Computer Engineering", 2018, "Delhi", 8), new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67), new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164), new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26), new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12), new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90), new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324), new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433), new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7), new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));
        // find the name start with Alphabet
        System.out.println("@@@ find the name start with Alphabet 'A' @@@");
        List<Student> AStudentList = list.stream().filter(student -> student.getFirstName().startsWith("A")).peek(System.out::println).collect(Collectors.toList());
        //Group The Student By Department Names
        System.out.println("@@@ Group The Student By Department Names @@@");
        Map<String, List<Student>> collect = list.stream().collect(Collectors.groupingBy(student -> student.getDepartmentName()));
        Set<String> stringSet = collect.keySet().stream().peek(s -> System.out.println(s + " " + collect.get(s))).collect(Collectors.toSet());

        System.out.print("@@@ Find the total count of student using stream @@@ = ");
        System.out.println(list.stream().count());

        System.out.print("@@@ Find the max age of student @@@ = ");
        OptionalInt count = list.stream().mapToInt(s -> s.getAge()).max();
        System.out.println(count.getAsInt());

        System.out.println("@@@ Department Names @@@");
        List<String> collect1 = list.stream().map(student -> student.getDepartmentName()).distinct().collect(Collectors.toList());
        System.out.println(collect1);

        System.out.println("@@@ Find the count of student in each department @@@");
        Map<String, Long> collect2 = list.stream().collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.counting()));
        Set<String> stringSet2 = collect2.keySet().stream().peek(s -> System.out.println(s + " " + collect2.get(s))).collect(Collectors.toSet());

        System.out.println("@@@  Find the list of students whose age is less than 30 @@@");
        Set<String> collect3 = list.stream().filter(student -> student.getAge() < 30)
                .map(s->s.getFirstName() +" "+ s.getLastName())
                .collect(Collectors.toSet());
        System.out.println(collect3);

        System.out.println("@@@ Find the list of students whose rank is in between 50 and 100 @@@");
        Set<Student> collect4 = list.stream().filter(s -> s.getRank() > 50 && s.getRank() < 100).collect(Collectors.toSet());
        System.out.println(collect4);

        System.out.println("@@@ Find the average age of male and female students @@@");
        Map<String, Double> collect5 = list.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        Set<String> stringSet3 = collect5.keySet().stream().peek(s -> System.out.println(s + " " + collect5.get(s))).collect(Collectors.toSet());

        System.out.println("@@@ Find the department who is having maximum number of students @@@");
        Map.Entry<String, Long> stringLongEntry = list.stream().collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println(stringLongEntry);

        System.out.println("@@@ Find the Students who stays in Delhi and sort them by their names @@@");
        Set<Student> delhi = list.stream().filter(s -> s.getCity().equalsIgnoreCase("delhi")).sorted(Comparator.comparing(Student::getFirstName)).collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(delhi);

        System.out.println("@@@ Find the average rank in all departments @@@");
        Map<String, Double> collect6 = list.stream().collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.averagingInt(Student::getRank)));
        System.out.println(collect6);

        System.out.println("@@@  Find the highest rank in each department @@@");
        Map<String, Optional<Student>> collect7 = list.stream().collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.minBy(Comparator.comparingInt(Student::getRank))));
        System.out.println(collect7);

        System.out.println("@@@ Find the list of students and sort them by their rank @@@");
        List<Student> collect8 = list.stream().sorted(Comparator.comparingInt(Student::getRank)).collect(Collectors.toList());
        System.out.println(collect8);

        System.out.println(" @@@ Find the student who has second rank @@@");
        Student student = list.stream().sorted(Comparator.comparingInt(Student::getRank)).skip(1).findFirst().get();
        System.out.println(student);

        List<String> cities = new ArrayList<>(Arrays.asList("Delhi","Mumbai","Pune","Goa","Benguluru"));
        Consumer<String> consumer = city-> System.out.println(city);
        Consumer<String> consumer1 = consumer.andThen(city -> city.equals("Mumbai"));
        cities.forEach(consumer1);

        List<String> stringStream = cities.stream().map(city -> city.substring(0, 2)).collect(Collectors.toList());
        System.out.println(stringStream);

        System.out.println("@@@ Find the Student name and map them with comma separated  @@@");
        String collect12 = list.stream().map(s -> s.getFirstName() + " " + s.getLastName()).collect(Collectors.joining(","));
        System.out.println(collect12);

        System.out.println("@@@ Compose and andThen methods from Function");
        List<Integer> list1 = List.of(10, 3, 6, 20, 30, 12, 1);
        Function<Integer,Integer> half = a->a/2;
        Function<Integer,Integer> twice = a->a*a;

        Function<Integer,Integer> listAndThen = half.andThen(twice);
        Function<Integer,Integer> listCompose = half.compose(twice);
        List<Integer> collect9 = list1.stream().map(listAndThen).collect(Collectors.toList());
        List<Integer> collect10 = list1.stream().map(listCompose).collect(Collectors.toList());
        System.out.println(collect9);
        System.out.println(collect10);

        System.out.println("@@@ Flat Map @@@");
        List<List<Integer> > number = new ArrayList<>();
        int[][] arr = {{1,2},{3,4},{5,6}};

//        Arrays.asList(arr).stream().flatMapToInt(i -> Arrays.stream(i).sorted()).collect(Collectors.joining());

        // adding the elements to number arraylist
        number.add(Arrays.asList(10, 20,1,2));
        number.add(Arrays.asList(30, 40,3,4));
        number.add(Arrays.asList(50, 60,3,4));
        number.add(Arrays.asList(70, 80,7,8));

        List<Integer> collect11 = number.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(collect11);


        System.out.println("@@@ find max length in String  @@@");
        String s = cities.stream().max(Comparator.comparingInt(String::length)).get();
        Optional<Map.Entry<Integer, List<String>>> collect13 = cities.stream().collect(Collectors.groupingBy(String::length))
                .entrySet().stream().max(Map.Entry.comparingByKey());
        System.out.println("Max length = "+ s +" " + collect13);

        Object[] intArr = list1.toArray();
        Arrays.stream(intArr).forEach(System.out::println);

        int[] a = {2,5,4,5,6,5,11};
        Optional<Map.Entry<Integer, Long>> max = Arrays.stream(a).boxed()
                .collect(Collectors.groupingBy(z -> z, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue());
//                 .forEach((k,v)-> System.out.println(k+" "+v.size()));
        System.out.println(max);

        int[] oddEven = {2,3,4,5,6,7,8,9,10,11};
        System.out.println("Odd and even list from stream");
        BiConsumer<Boolean,List<Integer>> biConsumer = (isEven , listBiConsumer)->{
            if(isEven){
                System.out.println("Even = ");
                listBiConsumer.forEach(System.out::println);
            }else{
                System.out.println("Odd = ");
                listBiConsumer.forEach(System.out::println);
            }
        };
//        biConsumer.accept(true,Arrays.asList(1,2,3,4,5,6,7,8)); for calling biConsumer
        Arrays.stream(oddEven).boxed().collect(Collectors.groupingBy(z -> z % 2 == 0)).forEach(biConsumer);
//        System.out.println(collect14);

        //find charactor count
//        String charCount="Thundderrrwwss";
//        char[] chars = charCount.toCharArray();
//
//        System.out.println("Count char in the String");
//        List<Integer> collect14 = Arrays.stream(Stream.of(chars).toArray()).map(o -> Character.getNumericValue((Character) o)).collect(Collectors.toList());
//
//        Map<Integer, Long> collect15 = collect14.stream().collect(Collectors.groupingBy(t -> t, Collectors.counting()));
//        collect15.forEach((key, value) -> System.out.println(key +" $ "+ value));
//        //.entrySet().stream().forEach(listEntry -> System.out.println(listEntry.getKey() +" "+listEntry.getValue()));
//
//        // find sub string
//        String[] strs = {"aaa","aa","aaa"};
//        Arrays.stream(strs).map(String::toCharArray).collect(Collectors.groupingBy(Object::toString));


    }

}
