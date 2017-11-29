package com.company.javaTest;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testPatternQuote {

    public static final String PARAMETER_NAMED_GROUP = "name";
    public static final String PARAMETERIZED_VALUE_REGEX = "\\{\\{\\s*(?<" + PARAMETER_NAMED_GROUP + ">[^\\s{}]+)\\s*\\}\\}";
    public static final Pattern PARAMETERIZED_PATTERN = Pattern.compile(PARAMETERIZED_VALUE_REGEX);

    public static void main(String[] args) {
//        String st = "$dependency.testAccount.roleArn";
//        String ts = Pattern.quote(st);
        //System.out.println(ts);
//        List<Integer> mylist = new ArrayList<Integer>();
//        //System.out.println(String.format("kasdjlask %d",mylist.size()));
//
//        final ZonedDateTime nowInUtc = ZonedDateTime.now(ZoneId.of("UTC"));
//        System.out.println(nowInUtc);
//        List<String> myList = new ArrayList<>();
//        myList.add("{{InstanceIds}}");
//        if (myList instanceof Map) {
//            System.out.println("I am a list");
//        }
        //System.out.println(myList);
//        String str = "/tmp/aws-update-linux-instance --pre-update-script '{{PreUpdateScript}}' --post-update-script '{{PostUpdateScript}}' --include-packages '{{IncludePackages}}' --exclude-packages '{{ExcludePackages}}' 2>&1 | tee /tmp/aws-update-linux-instance.log";
//        String regex = "\\{\\{([A-Za-z]{1,50})}}";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(str);
//        List<String> matches = new ArrayList<>();
//        while (matcher.find()) {
//            matches.add(matcher.group(1));
//        }
//        System.out.println(matches);
//        String str = Instant.now().toString();
//        System.out.println(str);
//        String
//        Instant now = Instant.now();
//        Optional<Instant> myOpt = Optional.of(now);
//        System.out.println(myOpt.toString());

//        String timeString = "";
//        Date.from(Instant.parse(timeString));
//        String temp = "{\"key\":\"value\"}";
//        System.out.println(temp);
        String temp = "{\n  \"schemaVersion\":\"0.3\",\n  \"description\":\"Updates AMI with Linux distribution packages and Amazon software. For details,see https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/sysman-ami-walkthrough.html\",\n  \"assumeRole\":\"{{AutomationAssumeRole}}\",\n  \"parameters\":{\n    \"AutomationAssumeRole\":{\n      \"type\":\"String\",\n      \"description\":\"(Required) The ARN of the role that allows Automation to perform the actions on your behalf.\",\n      \"default\":\"arn:aws:iam::{{global:ACCOUNT_ID}}:role/AutomationServiceRole\"\n    }\n  },\n  \"mainSteps\":[\n      {\n      \"name\": \"makeStack\",\n      \"action\": \"aws:createStack\",\n      \"maxAttempts\": 1,\n      \"onFailure\": \"Abort\",\n      \"inputs\": {\n        \"StackName\": \"AutomationLambdaStackd494f8c8\",\n        \"TemplateURL\": \"https://s3-external-1.amazonaws.com/cf-templates-kmge2usmbepq-us-east-1/20172094Oz-new.template9syery2dekp\",\n        \"TimeoutInMinutes\": 5\n      }\n    }\n\n    ]\n}\n";
        System.out.println(temp.length());
        List<String> res = testPatternQuote.resolveParameterNames(temp);
        System.out.println(res);


    }
    public static String resolveParameterName(final String value) {
        final Matcher matcher = PARAMETERIZED_PATTERN.matcher(value);
        return matcher.find() ? matcher.replaceAll(matcher.group(PARAMETER_NAMED_GROUP)).trim() : null;
    }

    public static List<String> resolveParameterNames(final String value) {

        final Matcher matcher = PARAMETERIZED_PATTERN.matcher(value);

        List<String> parameterNames = new ArrayList<>();
        while (matcher.find()) {
            String nextParameterName = matcher.group(PARAMETER_NAMED_GROUP);
            parameterNames.add(nextParameterName);
        }

        return parameterNames;
    }
}
