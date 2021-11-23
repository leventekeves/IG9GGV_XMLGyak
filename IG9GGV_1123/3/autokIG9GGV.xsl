<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<body>
				<h2>Lista</h2>
				<ul>
					<xsl:for-each select="autok/auto">
						<li>
							<xsl:value-of select="@rsz" />, 
							<xsl:value-of select="ar" />
						</li>
					</xsl:for-each>
				</ul>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>