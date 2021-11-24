<!DOCTYPE html>
<html lang="en">
<head>
    <title>Code</title>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
<pre id="code_snippet"><code>
        ${code}
    </code></pre>
<span id="load_date">
    ${date}
    </span>
<#if views != 0>
    <span id="views_restriction"> ${views} </span>
</#if>
<#if time != 0>
    <span id="views_restriction"> ${time} </span>
</#if>

</body>
</html>