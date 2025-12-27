# Encryption 项目详解

## 📋 项目概述

Encryption 是一个基于 Java 开发的轻量级加密工具库，提供多种加密算法和编码方式，旨在为开发者提供简单易用但功能强大的数据安全解决方案。该项目采用工厂模式和单例模式设计，具有良好的扩展性和灵活性。

## 🚀 核心功能

### 🔐 加密算法
- **映射表加密**：基于随机生成的字符映射表进行加密，映射表可持久化存储
- **XOR加密**：基于异或运算的轻量级加密方式
- **Caesar加密**：经典的移位加密算法

### 🔧 编码/解码功能
- **Base64编码**：标准的Base64编码实现
- **序列化编码**：对象序列化与反序列化支持

### 📊 配置管理系统
- 可自定义ASCII字符范围
- 可配置密钥存储路径
- 支持动态修改加密参数

### 🗄️ 数据持久化
- 使用EasyDB库实现配置和密钥的持久化存储
- 自动保存和加载加密映射表

## 📁 项目结构

```
src/
├── main/
│   ├── java/com/probie/
│   │   ├── Config/                # 配置相关类
│   │   │   ├── ConfigFactory.java # 配置工厂
│   │   │   └── KeyConfig.java     # 密钥配置
│   │   ├── Encoder/               # 编码器实现
│   │   │   ├── EncoderFactory.java     # 编码器工厂
│   │   │   ├── Base64Encoder.java      # Base64编码器
│   │   │   ├── XOEncoder.java          # XOR编码器
│   │   │   ├── CaesarEncoder.java      # Caesar编码器
│   │   │   └── SerializeEncoder.java   # 序列化编码器
│   │   ├── Decoder/               # 解码器实现
│   │   │   ├── DecoderFactory.java     # 解码器工厂
│   │   │   └── SerializeEncoder.java   # 序列化解码器
│   │   ├── Encrypter/             # 加密器实现
│   │   │   ├── EncrypterFactory.java   # 加密器工厂
│   │   │   └── MapEncrypter.java       # 映射表加密器
│   │   ├── Decrypter/             # 解密器实现
│   │   │   ├── DecrypterFactory.java   # 解密器工厂
│   │   │   └── MapDecrypter.java       # 映射表解密器
│   │   ├── Worder/                # 文本处理工具
│   │   │   └── WorderFactory.java      # Worder工厂
│   │   ├── Database/              # 数据库操作
│   │   │   └── Local/             # 本地数据库实现
│   │   ├── Encryption.java        # 核心入口类
│   │   └── Main.java              # 程序入口
│   └── resources/                 # 资源文件
└── test/                          # 测试代码
```

## 🛠️ 技术栈

- **编程语言**：Java 21
- **构建工具**：Maven
- **数据库依赖**：EasyDB 2.6.0
- **设计模式**：工厂模式、单例模式

## 📖 设计理念

### 🏗️ 架构设计
项目采用分层架构，主要分为以下几层：
1. **核心层**：Encryption类作为中心入口，管理各工厂实例
2. **工厂层**：各Factory类负责创建和管理具体实现类的实例
3. **实现层**：具体的加密、解密、编码、解码算法实现
4. **配置层**：管理系统配置和密钥存储

### 🎯 设计原则
- **单一职责原则**：每个类都有明确的职责边界
- **开闭原则**：易于扩展新的加密算法，无需修改现有代码
- **依赖倒置原则**：高层模块依赖抽象接口，不依赖具体实现
- **单例模式**：所有主要组件都采用单例模式，确保资源高效利用

## 💻 快速开始

### 📋 环境要求
- JDK 21 或更高版本
- Maven 3.8 或更高版本

### 🚀 安装步骤
1. 克隆项目代码
```bash
git clone <项目仓库地址>
```

2. 进入项目目录
```bash
cd Encryption
```

3. 使用Maven构建项目
```bash
mvn clean package
```

## 📚 使用指南

### 🔑 基本用法

#### 初始化加密工具
```java
// 获取Encryption实例
Encryption encryption = Encryption.getInstance();
```

#### 映射表加密/解密
```java
// 加密文本
String plainText = "Hello, World!";
String encryptedText = encryption.getEncrypterFactory().getMapEncrypter().encryptByMap(plainText);
System.out.println("加密后: " + encryptedText);

// 解密文本
String decryptedText = encryption.getDecrypterFactory().getMapDecrypter().decryptByMap(encryptedText);
System.out.println("解密后: " + decryptedText);
```

#### Base64编码
```java
// 编码文本
String text = "Hello, World!";
String encodedText = encryption.getEncoderFactory().getBase64Encoder().encodeBase64(text);
System.out.println("Base64编码后: " + encodedText);
```

### ⚙️ 高级配置

#### 自定义配置参数
```java
// 设置密钥存储路径
Encryption.setFilePath("D:\\CustomKeys\");

// 设置ASCII字符范围
Encryption.setAscllMin(32);  // 空格
Encryption.setAscllMax(126); // ~

// 自定义密钥标识
Encryption.setKeyMap("custom_map_key");
Encryption.setKeyXO("custom_xor_key");
Encryption.setKeyCaesar("custom_caesar_key");
```

## 🛡️ 安全注意事项

1. **密钥管理**：密钥存储在本地文件中，请确保该文件的访问权限受到严格控制
2. **算法选择**：根据数据敏感度选择合适的加密算法
3. **自定义配置**：修改默认配置时，请确保了解其安全影响
4. **定期更新**：建议定期更新加密密钥以提高安全性

## ❓ 常见问题

**Q: 加密后的文本无法正确解密怎么办？**
A: 请确保解密时使用的密钥与加密时完全相同，并且没有修改过ASCII范围设置。

**Q: 如何备份加密密钥？**
A: 只需备份密钥存储文件即可，默认路径为项目根目录下的"Key"文件。

**Q: 可以同时使用多种加密算法吗？**
A: 可以，您可以先使用一种算法加密，然后再使用另一种算法对结果进行二次加密。

## 🚀 开发与扩展

### 添加新的加密算法
1. 在Encrypter包下创建新的加密器类，实现加密逻辑
2. 在EncrypterFactory中添加获取新加密器实例的方法
3. 类似地，可以添加新的解密器、编码器和解码器

### 示例：添加新的加密器
```java
// 1. 创建新的加密器类
public class NewEncrypter {
    private volatile static NewEncrypter INSTANCE;
    
    public synchronized static NewEncrypter getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new NewEncrypter();
        }
        return INSTANCE;
    }
    
    public String encrypt(Object text) {
        // 实现加密逻辑
        return encryptedText;
    }
}

// 2. 在EncrypterFactory中添加方法
public NewEncrypter getNewEncrypter() {
    return NewEncrypter.getInstance();
}
```

## 📄 许可证

本项目采用MIT许可证，详情请见LICENSE文件。

## 🙏 致谢

感谢所有为项目做出贡献的开发者和支持者。

---

*版本：2.1.1 | 最后更新：2025-11-20*