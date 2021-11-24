<!DOCTYPE html>
<html lang="en">
<head>
    <title>Create</title>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
<label for="code_snippet">Your code</label><br><code><textarea id="code_snippet" name="textarea" rows="30" cols="80" placeholder="// write your code here"></textarea></code><br>
<label for="time_restriction"></label>Times<br><input id="time_restriction" type="number" value=0/><br>
<label for="views_restriction"></label>Views<br><input id="views_restriction" type="number" value=0/><br>

<script type="text/javascript" src="/js/getNewCode.js"></script>
<button id="send_snippet" type="submit" onclick="send()">Submit</button>
</body>
</html>