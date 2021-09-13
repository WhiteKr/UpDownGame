//
//  ViewController.swift
//  UpDownGame
//
//  Created by WhiteKr on 2021/09/13.
//

import UIKit

class ViewController: UIViewController {
    
    var randomValue: Int = 0
    var tryCount: Int = 0
    let maximumRamdomValue: Int = 30
    let maximumTryCount: Int = 5
    @IBOutlet weak var slider: UISlider!
    @IBOutlet weak var tryCountLabel: UILabel!
    @IBOutlet weak var sliderValueLabel: UILabel!
    @IBOutlet weak var minimunValueLabel: UILabel!
    @IBOutlet weak var maximunValueLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        slider.setThumbImage(#imageLiteral(resourceName: "slider_thumb"), for: .normal)
        reset()
    }
    
    @IBAction func sliderValueChanged(_ sender: UISlider) {
        let intValue: Int = Int(sender.value)
        sliderValueLabel.text = String(intValue)
    }
    
    func showAlert(message: String) {
        let alert = UIAlertController(title: nil,
                                      message: message,
                                      preferredStyle: .alert)
        let okAction = UIAlertAction(title: "OK", style: .default) {
            (action) in self.reset()
        }
        
        alert.addAction(okAction)
        present(alert, animated: true, completion: nil)
    }
    
    @IBAction func touchUpHitButton(_ sender: UIButton) {
        let hitValue: Int = Int(slider.value)
        slider.value = Float(hitValue)
        
        tryCount += 1
        tryCountLabel.text = "\(tryCount) / \(maximumTryCount)"
        
        if randomValue == hitValue {
            showAlert(message: "YOU HIT!!")
            reset()
        } else if tryCount >= maximumTryCount {
            showAlert(message: "You lose...")
            reset()
        } else if randomValue > hitValue {
            slider.minimumValue = Float(hitValue)
            minimunValueLabel.text = String(hitValue)
        } else {
            slider.maximumValue = Float(hitValue)
            maximunValueLabel.text = String(hitValue)
        }
        
        slider.value = (slider.maximumValue / 2) + (slider.minimumValue / 2)
        sliderValueLabel.text = String(Int(slider.value))
    }
    
    @IBAction func touchUpResetButton(_ sender: UIButton) {
        reset()
    }
    
    func reset() {
        randomValue = Int.random(in: 0...maximumRamdomValue)
        print(randomValue)
        tryCount = 0
        tryCountLabel.text = "0 / \(maximumTryCount)"
        slider.minimumValue = 0
        slider.maximumValue = Float(maximumRamdomValue)
        slider.value = Float(maximumRamdomValue / 2)
        minimunValueLabel.text = String(Int(slider.minimumValue))
        maximunValueLabel.text = String(Int(slider.maximumValue))
        sliderValueLabel.text = String(Int(slider.value))
    }

}
