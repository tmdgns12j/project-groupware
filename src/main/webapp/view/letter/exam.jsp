<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Canvas</title>
<style type="text/css">
    body{
        line-height:2em;        
        font-family:"���� ���";
}
    ul, li{ 
        list-style:none;
        text-align:center;
        padding:0;
        margin:0;
}

    #mainWrapper{
        width: 800px;
        margin: 0 auto; /*��� ����*/
    }

    #mainWrapper > ul > li:first-child {
        text-align: center;
        font-size:14pt;
        height:40px;
        vertical-align:middle;
        line-height:30px;
}

    #ulTable {margin-top:10px;}
    

    #ulTable > li:first-child > ul > li {
        background-color:#c9c9c9;
        font-weight:bold;
        text-align:center;
}

    #ulTable > li > ul {
        clear:both;
        padding:0px auto;
        position:relative;
        min-width:40px;
}
    #ulTable > li > ul > li { 
        float:left;
        font-size:10pt;
        border-bottom:1px solid silver;
        vertical-align:baseline;
}    

    #ulTable > li > ul > li:first-child               {width:10%;} /*No �� ũ��*/
    #ulTable > li > ul > li:first-child +li           {width:45%;} /*���� �� ũ��*/
    #ulTable > li > ul > li:first-child +li+li        {width:20%;} /*�ۼ��� �� ũ��*/
    #ulTable > li > ul > li:first-child +li+li+li     {width:15%;} /*�ۼ��� �� ũ��*/
    #ulTable > li > ul > li:first-child +li+li+li+li{width:10%;} /*��ȸ�� �� ũ��*/

    #divPaging {
          clear:both; 
        margin:0 auto; 
        width:220px; 
        height:50px;
}

    #divPaging > div {
        float:left;
        width: 30px;
        margin:0 auto;
        text-align:center;
}

    #liSearchOption {clear:both;}
    #liSearchOption > div {
        margin:0 auto; 
        margin-top: 30px; 
        width:auto; 
        height:100px;

}

    .left {
        text-align : left;
}


</style>

</head>
<body>
    <div id="mainWrapper">

        <ul>
            <!-- �Խ��� ���� -->
            <li>�Խ��� Title </li>

            <!-- �Խ��� ���  -->
            <li>
                Table
                <ul id ="ulTable">
                    <li>
                        <ul>
                            <li>No</li>
                            <li>����</li>
                            <li>�ۼ���</li>
                            <li>�ۼ���</li>
                            <li>��ȸ��</li>
                        </ul>
                    </li>
                    <!-- �Խù��� ��µ� ���� -->
                    <li>
                        <ul>
                            <li>1</li>
                            <li class="left">����������������1</li>
                            <li>2014.07.09</li>
                            <li>�ڹ�ŷ</li>
                            <li>0</li>
                        </ul>
                    </li>

                    <li>
                        <ul>
                            <li>2</li>
                            <li class="left">����������������1</li>
                            <li>2014.07.09</li>
                            <li>�ڹ�ŷ</li>
                            <li>0</li>
                        </ul>
                    </li>

                    <li>
                        <ul>
                            <li>3</li>
                            <li class="left">����������������1</li>
                            <li>2014.07.09</li>
                            <li>�ڹ�ŷ</li>
                            <li>0</li>
                        </ul>
                    </li>

                    <li>
                        <ul>
                            <li>4</li>
                            <li class="left">����������������1</li>
                            <li>2014.07.09</li>
                            <li>�ڹ�ŷ</li>
                            <li>0</li>
                        </ul>
                    <li>                                        
                </ul>
            </li>

            <!-- �Խ��� ����¡ ���� -->
            <li>
                <div id="divPaging">
                    <div>��</div>
                       <div><b>1</b></div>
                    <div>2</div>
                    <div>3</div>
                    <div>4</div>
                    <div>5</div>
                    <div>��</div>
                </div>
            </li>

            <!-- �˻� �� ���� -->
            <li id='liSearchOption'>
                <div>
                    <select id='selSearchOption' >
                        <option value='A'>����+����</option>
                        <option value='T'>����</option>
                        <option value='C'>����</option>
                    </select>
                    <input id='txtKeyWord' />
                    <input type='button' value='�˻�'/>
                </div>
                </li>

        </ul>
    </div>
</body>
</html>
