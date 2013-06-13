package spring.webapp.loginsystem.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.webapp.loginsystem.entity.Datei;
import spring.webapp.loginsystem.service.DateiService;

/**
 * Controller for Mapping a file download page in course page.
 * 
 * @author Songhua Cui
 * 
 */
@Controller
@RequestMapping
public class DateiController {

	@Autowired
	private DateiService dateiService;

	/**
	 * Path of the file to be downloaded, relative to application's directory
	 */
	private final String filePath = "/files/";

	/**
	 * upload
	 * @param model
	 * @param request
	 * @param response
	 * @param kursId
	 * @return @throws Exception
	 */
	@RequestMapping(value = "/upload")
	public String upload(ModelMap model, HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "courseId", required = false) String kursId)
			throws Exception {

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("file");
		String originalFilename = multipartFile.getOriginalFilename();

		Datei datei = new Datei();
		datei.setName(originalFilename);
		datei.setBeschreibung(ServletRequestUtils.getStringParameter(request,
				"notes"));
		datei.setTyp(multipartFile.getContentType());
		// datei.setFile(multipartFile.getBytes());
		// TODO Add file Information into datebase.
		dateiService.saveDatei(datei, kursId);

		try {
			/*
			 * InputStream inputStream = null; OutputStream outputStream = null;
			 */
			if (multipartFile.getSize() > 0) {
				/*
				 * inputStream = multipartFile.getInputStream();
				 */
				// File realUpload = new File("C:/");
				// get absolute path of the application
				String appPath = request.getServletContext().getRealPath("");
				String fullPath = appPath + filePath;
				File folder = new File(fullPath);
				if (!folder.exists()) {
					folder.mkdirs();
				}

				File file = new File(fullPath + "/" + originalFilename);

				// 如果文件不存在写文件到服务器
				multipartFile.transferTo(file);
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errors", e.getMessage());
		}
		// TODO Add info if a file was uplaoded successfully.
		/*
		 * model.addAttribute("success", <h3 style="color: green;">File has been
		 * uploaded successfully.</h3> <br> File Name : ${FORM.name}.);
		 */
		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}

	/**
	 * download file
	 * 
	 * @param dateiId
	 * @param request
	 * @param response
	 * @return @throws IOException
	 */
	@RequestMapping(value = "/download")
	@ResponseBody
	public byte[] download(
			@RequestParam(value = "id", required = false) Long dateiId,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		Datei datei = dateiService.getDateiByDateiId(dateiId);

		String nurDateiName = datei.getName();

		// get absolute path of the application
		String appPath = request.getServletContext().getRealPath("");

		// construct the complete absolute path of the file
		String fullPath = appPath + filePath;

		String dateiName = fullPath + nurDateiName;
		File file = new File(dateiName);
		byte[] bytes = org.springframework.util.FileCopyUtils
				.copyToByteArray(file);

		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ nurDateiName + "\"");
		response.setContentLength(bytes.length);
		response.setContentType(datei.getTyp());
		response.setCharacterEncoding("UTF-8");

		return bytes;
	}

	/**
	 * delete file
	 * @param model
	 * @param request
	 * @param dateiId
	 * @return 
	 */
	@RequestMapping(value = "/delete")
	public String delete(ModelMap model, HttpServletRequest request,
			@RequestParam(value = "fileId", required = false) Long dateiId) {
		dateiService.deleteDateiByDateiId(dateiId);
		/*
		 * model.addAttribute("message",
		 * "Datei wurde erfolgreich vom Server entfernt.");
		 */
		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}
}
