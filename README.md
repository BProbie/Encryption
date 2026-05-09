# ⭐原创开源工具

### 工具名称：Encryption（加解密兼编解码工具）

### 工具版本：v2.5.0（稳定版）

### 开发语言：Java（JDK-21.0.8）

### 开发时间：2025年10月01日 ~ 至今持续更新

### 开源地址（Github）：https://github.com/BProbie/Encryption/

### 开源协议（MIT）：https://github.com/BProbie/Encryption/raw/refs/heads/master/LICENSE/

### 下载地址：https://github.com/BProbie/Encryption/releases/tag/v2.5.0/

### 依赖工具：Maven

### 依赖技术：

- ##### EasyDB（💎个人原创：https://github.com/BProbie/EasyDB/

- ##### JUnit（JUnit5）



# ⭐快速开始

### ① 添加JitPack仓库

```xml
<repositories>

    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
        <snapshots>
            <enabled>true</enabled>
            <updatePolicy>always</updatePolicy> 
        </snapshots>
    </repository>
    
</repositories>
```

### ② 添加工具依赖

```xml
<dependencies>
    
    <dependency>
        <groupId>com.github.BProbie</groupId>
        <artifactId>Encryption</artifactId>
        <version>master-SNAPSHOT</version>
    </dependency>
    
</dependencies>
```

###  

# ⭐使用教程

### 编码

##### 序列化

```java
Object data = Encryption.getInstance().getEncoderFactory().getSerializeEncoder().encodeSerialize("data");
```

##### 亦或（可加盐）

```java
Object data = Encryption.getInstance().getEncoderFactory().getXOEncoder().encodeXO("data");
Object data = Encryption.getInstance().getEncoderFactory().getXOEncoder().encodeXO("data", 10);
Object data = Encryption.getInstance().getEncoderFactory().getXOEncoder().encodeXOUnsigned("data");
Object data = Encryption.getInstance().getEncoderFactory().getXOEncoder().encodeXOUnsigned("data", 10);
```

##### 凯撒（可加盐）

```java
Object data = Encryption.getInstance().getEncoderFactory().getCaesarEncoder().encodeCaesar("data");
Object data = Encryption.getInstance().getEncoderFactory().getCaesarEncoder().encodeCaesar("data", 10);
Object data = Encryption.getInstance().getEncoderFactory().getCaesarEncoder().encodeCaesarUnsigned("data");
Object data = Encryption.getInstance().getEncoderFactory().getCaesarEncoder().encodeCaesarUnsigned("data", 10);
```

##### Base64

```java
Object data = Encryption.getInstance().getEncoderFactory().getBase64Encoder().encodeBase64("data");
```

### 解码

##### 序列化

```java
Object data = Encryption.getInstance().getDecoderFactory().getSerializeEncoder().decodeSerialize("data");
```

##### 亦或（可加盐）

```java
Object data = Encryption.getInstance().getDecoderFactory().getXODecoder().decodeXO("data");
Object data = Encryption.getInstance().getDecoderFactory().getXODecoder().decodeXO("data", 10);
Object data = Encryption.getInstance().getDecoderFactory().getXODecoder().decodeXOUnsigned("data");
Object data = Encryption.getInstance().getDecoderFactory().getXODecoder().decodeXOUnsigned("data", 10);
```

##### 凯撒（可加盐）

```java
Object data = Encryption.getInstance().getDecoderFactory().getCaesarDecoder().decodeCaesar("data");
Object data = Encryption.getInstance().getDecoderFactory().getCaesarDecoder().decodeCaesar("data", 10);
Object data = Encryption.getInstance().getDecoderFactory().getCaesarDecoder().decodeCaesarUnsigned("data");
Object data = Encryption.getInstance().getDecoderFactory().getCaesarDecoder().decodeCaesarUnsigned("data", 10);
```

##### Base64

```java
Object data = Encryption.getInstance().getDecoderFactory().getBase64Decoder().decodeBase64("data");
```

### 加密

##### Map（独创）

```java
Object data = Encryption.getInstance().getEncrypterFactory().getMapEncrypter().encryptByMap("data");
```

### 解密

##### Map（独创）

```java
Object data = Encryption.getInstance().getDecrypterFactory().getMapDecrypter().decryptByMap("data");
```



# ⭐更多动能

### ① 反调试

```java
if (Encryption.getInstance().isDebug()) {
    System.exit(0);
}
```

### ② 获取一个随机数

```java
int random = Encryption.getInstance().getWorderFactory().getRandomer().getRandomInteger(1, 10);
```

### ③ 获取一个随机字符

```java
char c = Encryption.getInstance().getWorderFactory().getRandomer().getRandomAscll();
char c = Encryption.getInstance().getWorderFactory().getRandomer().getRandomAscllUnsigned();
```

### ④ 字符去符号化

```java
int c = Encryption.getInstance().getWorderFactory().getUnsigneder().unsignedAscll(10);
char c = Encryption.getInstance().getWorderFactory().getUnsigneder().unsignedAscll('a');
```



# ⭐项目结构

```markdown
Encryption
├── .github
├── .gitignore
├── .idea # 已在仓库中删减
├── .mvn # 已在仓库中删除
├── LICENSE
├── out # 已在仓库中删除
├── pom.xml
├── README.md
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── probie
│   │   │           └── encryption
│   │   │               ├── Main.java
│   │   │               ├── config
│   │   │               │   ├── api
│   │   │               │   ├── ConfigFactory.java
│   │   │               │   └── KeyConfig.java
│   │   │               ├── decoder
│   │   │               │   ├── api
│   │   │               │   ├── Base64Decoder.java
│   │   │               │   ├── CaesarDecoder.java
│   │   │               │   ├── DecoderFactory.java
│   │   │               │   ├── SerializeDecoder.java
│   │   │               │   └── XODecoder.java
│   │   │               ├── decrypter
│   │   │               │   ├── api
│   │   │               │   ├── DecrypterFactory.java
│   │   │               │   └── MapDecrypter.java
│   │   │               ├── encoder
│   │   │               │   ├── api
│   │   │               │   ├── Base64Encoder.java
│   │   │               │   ├── CaesarEncoder.java
│   │   │               │   ├── EncoderFactory.java
│   │   │               │   ├── SerializeEncoder.java
│   │   │               │   └── XOEncoder.java
│   │   │               ├── encrypter
│   │   │               │   ├── api
│   │   │               │   ├── EncrypterFactory.java
│   │   │               │   └── MapEncrypter.java
│   │   │               ├── encryption
│   │   │               │   ├── api
│   │   │               │   └── Encryption.java
│   │   │               └── worder
│   │   │                   ├── api
│   │   │                   ├── Randomer.java
│   │   │                   ├── Unsigneder.java
│   │   │                   └── WorderFactory.java
│   │   └── resources
│   │       └── META-INF
│   │           └── MANIFEST.MF
│   └── test
│       └── java
│           └── com
│               └── probie
│                   └── encryption
│                       └── MainTest.java
└── target # 已在仓库中删减
```



# ⭐技术细节

### ① 密钥可记录



# ⭐作者介绍

### 作者：probie

### 贡献：\[probie, probie, probie]



# ⭐疑问交流联系

### 如有疑问请通过提交Issue阐述，作者能看到且会经常查看！



# ❤❤❤