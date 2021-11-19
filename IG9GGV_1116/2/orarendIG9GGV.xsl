<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<body>
				<h2>Órarend</h2>
				<table border="1">
					<tr bgcolor="#9acd32">
						<th rowspan="2">ID</th>
						<th rowspan="2">Tárgy</th>
						<th colspan="3">Időpont</th>
						<th rowspan="2">Helyszín</th>
						<th rowspan="2">Oktató</th>
						<th rowspan="2">Szak</th>
					</tr>
					<tr bgcolor="#9acd32">
						<th>Nap</th>
						<th>Tól</th>
						<th>Ig</th>
					</tr>
					<xsl:for-each select="orarend/ora">
						<tr>
							<td>
								<xsl:value-of select="@id" />
							</td>
							<td>
								<xsl:value-of select="targy" />
							</td>
							<xsl:for-each select="idopont">
								<td>
									<xsl:value-of select="nap" />
								</td>
								<td>
									<xsl:value-of select="tol" />
								</td>
								<td>
									<xsl:value-of select="ig" />
								</td>
							</xsl:for-each>
							<td>
								<xsl:value-of select="helyszin" />
							</td>
							<td>
								<xsl:value-of select="oktato" />
							</td>
							<td>
								<xsl:value-of select="szak" />
							</td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>