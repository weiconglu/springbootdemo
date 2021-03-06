USE [master]
GO

/****** Object:  Database [springbootdemo]    Script Date: 2021/03/15 22:25:13 ******/
CREATE DATABASE [springbootdemo]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'springbootdemo', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\springbootdemo.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'springbootdemo_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\springbootdemo_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO

ALTER DATABASE [springbootdemo] SET COMPATIBILITY_LEVEL = 120
GO

IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [springbootdemo].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO

ALTER DATABASE [springbootdemo] SET ANSI_NULL_DEFAULT OFF 
GO

ALTER DATABASE [springbootdemo] SET ANSI_NULLS OFF 
GO

ALTER DATABASE [springbootdemo] SET ANSI_PADDING OFF 
GO

ALTER DATABASE [springbootdemo] SET ANSI_WARNINGS OFF 
GO

ALTER DATABASE [springbootdemo] SET ARITHABORT OFF 
GO

ALTER DATABASE [springbootdemo] SET AUTO_CLOSE OFF 
GO

ALTER DATABASE [springbootdemo] SET AUTO_SHRINK OFF 
GO

ALTER DATABASE [springbootdemo] SET AUTO_UPDATE_STATISTICS ON 
GO

ALTER DATABASE [springbootdemo] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO

ALTER DATABASE [springbootdemo] SET CURSOR_DEFAULT  GLOBAL 
GO

ALTER DATABASE [springbootdemo] SET CONCAT_NULL_YIELDS_NULL OFF 
GO

ALTER DATABASE [springbootdemo] SET NUMERIC_ROUNDABORT OFF 
GO

ALTER DATABASE [springbootdemo] SET QUOTED_IDENTIFIER OFF 
GO

ALTER DATABASE [springbootdemo] SET RECURSIVE_TRIGGERS OFF 
GO

ALTER DATABASE [springbootdemo] SET  DISABLE_BROKER 
GO

ALTER DATABASE [springbootdemo] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO

ALTER DATABASE [springbootdemo] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO

ALTER DATABASE [springbootdemo] SET TRUSTWORTHY OFF 
GO

ALTER DATABASE [springbootdemo] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO

ALTER DATABASE [springbootdemo] SET PARAMETERIZATION SIMPLE 
GO

ALTER DATABASE [springbootdemo] SET READ_COMMITTED_SNAPSHOT OFF 
GO

ALTER DATABASE [springbootdemo] SET HONOR_BROKER_PRIORITY OFF 
GO

ALTER DATABASE [springbootdemo] SET RECOVERY SIMPLE 
GO

ALTER DATABASE [springbootdemo] SET  MULTI_USER 
GO

ALTER DATABASE [springbootdemo] SET PAGE_VERIFY CHECKSUM  
GO

ALTER DATABASE [springbootdemo] SET DB_CHAINING OFF 
GO

ALTER DATABASE [springbootdemo] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO

ALTER DATABASE [springbootdemo] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO

ALTER DATABASE [springbootdemo] SET DELAYED_DURABILITY = DISABLED 
GO

ALTER DATABASE [springbootdemo] SET  READ_WRITE 
GO

ALTER DATABASE egs
COLLATE Japanese_XJIS_100_CS_AS_KS_WS;
GO