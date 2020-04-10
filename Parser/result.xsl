<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:template match="/">
        <html>

            <head>
                <style type="text/css">
                    table.tfmt {
                    border: 1px ;
                    }
                    td.colfmt {
                    border: 1px ;
                    background-color: white;
                    color: black;
                    text-align:center;
                    }
                    th {
                    background-color: green;
                    color: white;
                    }
                </style>
            </head>

            <body>
                <table class="tfmt">
                    <tr>
                        <th>№:</th>
                        <th>Name:</th>
                        <th>Price:</th>
                        <th>Weight:</th>
                        <th>Info:</th>
                        <th>Extra:</th>
                    </tr>

                    <xsl:for-each select="Array/dishes">
                        <tr>
                            <td class="colfmt">
                                <xsl:value-of select="link"/>
                                <xsl:if test="@count">
                                    (<xsl:value-of select="@count"/>)
                                </xsl:if>
                        </td>
                            <td class="colfmt">
                                <xsl:value-of select="name"/>
                            </td>
                            <td class="colfmt">
                                <xsl:value-of select="cost"/>
                            </td>
                            <td class="colfmt">
                                <xsl:value-of select="weight"/>
                            </td>
                            <td class="colfmt">
                                <xsl:for-each select="info">
                                    <table>
                                        <tr>
                                            <th>Review</th>
                                            <th>Consist</th>
                                        </tr>
                                        <tr>
                                            <td>
                                                <xsl:value-of select="review"/>
                                            </td>
                                            <td>
                                                <xsl:value-of select="consist"/>
                                            </td>
                                        </tr>
                                    </table>
                                </xsl:for-each>
                            </td>
                                <td class="colfmt">
                                    <xsl:for-each select="detail">
                                    <table>
                                        <tr>
                                            <th>Id</th>
                                            <th>Status</th>
                                        </tr>
                                            <tr>
                                                <td>
                                                    <xsl:value-of select="id"/>
                                                </td>
                                                <td>
                                                    <xsl:value-of select="status"/>
                                                </td>
                                            </tr>
                                    </table>
                                    </xsl:for-each>
                                </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>