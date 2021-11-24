<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Latest</title>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
<#list codeList as code>
    <pre class="code_snippet"><code>
        ${code.code}
    </code></pre>
    <span class="load_date">
    ${code.date}
    </span>
</#list>

</body>
</html>