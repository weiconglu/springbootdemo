USE [springbootdemo]
GO

/****** Object:  Table [dbo].[tb_t_employee]    Script Date: 05/09/2021 15:34:38 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[tb_t_employee](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[last_name] [varchar](50) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[gender] [int] NOT NULL,
	[age] [int] NOT NULL,
	[create_time] [datetime] NULL,
	[update_time] [datetime] NULL
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


